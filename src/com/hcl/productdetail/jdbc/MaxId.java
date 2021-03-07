package com.hcl.productdetail.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.productdetail.util.DbUtil;

public class MaxId {
	public int FindMaxId() {
		String query = "SELECT MAX(id) as id FROM product_tbl";
		int maxId = 1;
		try (Connection con = DbUtil.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				maxId = rs.getInt("id");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxId;
	}

}
