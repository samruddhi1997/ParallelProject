package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.capgemini.airlinereservationsystem.dao.ChangeTiketPriceInterface;
import com.capgemini.airlinereservationsystem.dto.ChangeTicketPriceBean;

public class ChangeTicketPrice implements ChangeTiketPriceInterface {

	public int changeTicketPrice() {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			con = DriverManager.getConnection(dburl, "root", "root");

			String query = " update ticket_details set price = ? where ticket_id = ? && flight_id = ? ";
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, ChangeTicketPriceBean.getNewPrice());
			pstmt.setInt(2, ChangeTicketPriceBean.getTicketId());
			pstmt.setInt(3, ChangeTicketPriceBean.getFlight_id());

			int res = pstmt.executeUpdate();

			return res;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return 0;
	}
}
