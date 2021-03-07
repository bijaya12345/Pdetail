package com.hcl.productdetail.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hcl.productdetail.util.DbUtil;

public class Insert {

	public static final String SQL = "insert into product_tbl(pro_name, pro_price,pro_dept)values(?,?,?)";

	public static void main(String[] args) {
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {

			ps.setString(1, "Dell");
			ps.setLong(2, 700);
			ps.setString(3, "laptop");
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
