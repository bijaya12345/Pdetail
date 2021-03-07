package com.hcl.productdetail.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hcl.productdetail.util.DbUtil;

public class TableCreation {

	public static final String SQL = "create table product_tbl(id int not null auto_increment, pro_name varchar(45), pro_price double, pro_dept varchar(45), primary key(id))";

	public static void main(String[] args) {
		try (Connection con = DbUtil.getConnection(); Statement st = con.createStatement();) {

			st.executeUpdate(SQL);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
