package com.capgemini.airlinereservationsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.airlinereservationsystem.dto.CustomerLogin;
import com.capgemini.airlinereservationsystem.dto.UserLoginBean;
import com.capgemini.airlinereservationsystem.dto.UserRegistrationBean;

public class UserLogin implements UserLoginDao {

	public List<String> login() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = " select customer_name,password from customer_details where customer_name = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, UserLoginBean.getCustomerName());
			rs = pstmt.executeQuery();

			List<String> al = new ArrayList<String>();
			while (rs.next()) {
				al.add(rs.getString("customer_name"));
				al.add(rs.getString("password"));

			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null)
					rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

}
