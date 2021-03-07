package com.hcl.productdetail.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.productdetail.jdbc.MaxId;
import com.hcl.productdetail.model.Product;
import com.hcl.productdetail.util.DbUtil;

/**
 * Servlet implementation class ProductFinder
 */
@WebServlet("/ProductFinder")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SQL = "select * from product_tbl where id=?";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String proId = request.getParameter("productId");
		if (!proId.matches("\\d+")) {
			RequestDispatcher rd = request.getRequestDispatcher("WrongInput.jsp");
			rd.forward(request, response);

		}

		else {
			int productId = Integer.parseInt(proId);
			MaxId maxId = new MaxId();
			int highestId = maxId.FindMaxId();
			// System.out.println(highestId);

			if (productId > highestId || productId < 1) {
				RequestDispatcher rd = request.getRequestDispatcher("WrongInput.jsp");
				rd.forward(request, response);
			} else {

				Product product = new Product();

				try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {
					ps.setInt(1, productId);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						// System.out.println("id is: " + rs.getInt("id"));
						product.setName(rs.getString("pro_name"));
						product.setPrice(rs.getDouble("pro_price"));
						product.setDepartment(rs.getString("pro_dept"));
//				System.out.println("product name is: " + rs.getString("pro_name"));
//				System.out.println("product price is: " + rs.getDouble("pro_price"));
//				System.out.println("product dept is: " + rs.getString("pro_dept"));
					}

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				RequestDispatcher rd = request.getRequestDispatcher("ProDetail.jsp");
				request.setAttribute("product", product);
				rd.forward(request, response);
			}
		}
	}

}
