package com.capgemini.airlinereservationsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.capgemini.airlinereservationsystem.dto.UserRegistrationBean;

public class UserRegistration {

	public int login() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into customer_details values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, UserRegistrationBean.getCustomerId());
			pstmt.setString(2, UserRegistrationBean.getCustomerName());
			pstmt.setString(3, UserRegistrationBean.getPassword());
			pstmt.setString(4, UserRegistrationBean.getDob());
			pstmt.setLong(5, UserRegistrationBean.getPhoneNumber());
			pstmt.setString(6, UserRegistrationBean.getEmail());
			pstmt.setString(7, UserRegistrationBean.getGovtId());
			pstmt.setString(8, UserRegistrationBean.getGender());
			pstmt.setString(9, UserRegistrationBean.getNationality());

			int res = pstmt.executeUpdate();
			return res;

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
			} catch (Exception e1) {

			}
		}
		return 0;

	}
}
