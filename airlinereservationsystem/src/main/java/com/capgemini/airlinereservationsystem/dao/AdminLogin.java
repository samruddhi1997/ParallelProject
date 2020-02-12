package com.capgemini.airlinereservationsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dto.AdminLoginBean;
import com.capgemini.airlinereservationsystem.exception.AdminNotFoundException;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;
import com.capgemini.airlinereservationsystem.service.impl.AdminLoginService;

public class AdminLogin implements AdminLoginDao {

	public List<String> login() {

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "select admin_name,password from admin_details where admin_name = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, AdminLoginBean.getAdminName());
			rs = pstmt.executeQuery();

			List<String> al = new ArrayList<String>();

			while (rs.next()) {

				al.add(rs.getString("admin_name"));
				al.add(rs.getString("password"));

			}
			return al;
		} catch (Exception e) {
			throw new LoginFailedException();

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

			}
		}

	}
}
