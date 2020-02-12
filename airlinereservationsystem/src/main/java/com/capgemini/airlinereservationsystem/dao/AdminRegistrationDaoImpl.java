package com.capgemini.airlinereservationsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.capgemini.airlinereservationsystem.dto.AdminRegistrationBean;
import com.capgemini.airlinereservationsystem.dto.UserRegistrationBean;

public class AdminRegistrationDaoImpl implements AdminRegistrationDao {

	public int adminregistration() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into admin_details values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, AdminRegistrationBean.getAdminId());
			pstmt.setString(2, AdminRegistrationBean.getAdminName());

			pstmt.setString(3, AdminRegistrationBean.getPassword());

			pstmt.setString(4, AdminRegistrationBean.getEmail());
			pstmt.setLong(5, AdminRegistrationBean.getPhoneNumber());

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
