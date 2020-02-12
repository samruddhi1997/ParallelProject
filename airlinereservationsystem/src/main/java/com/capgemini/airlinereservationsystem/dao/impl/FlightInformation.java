package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dao.FlightInfoInterface;
import com.capgemini.airlinereservationsystem.dto.FlightInformationBean;

public class FlightInformation implements FlightInfoInterface {

	static Logger log = LogManager.getLogger("admin");
	

	public List<String> flightInfo() {

		List<String> flightInfo = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://localhost:3306/airline_reservation_system_db";
			con = DriverManager.getConnection(dburl, "root", "root");

			String query = "select * from flight_details";
			stmt = con.createStatement();

			rs = stmt.executeQuery(query);
			flightInfo.add("\t");
			while (rs.next()) {

//				result = result + "\n" + rs.getInt("flight_id") + "\t\t" + rs.getString("flight_name") + "\t\t"
//						+ rs.getString("source") + "\t\t" + rs.getString("destination") + "\t\t"
//						+ rs.getTime("arrival_time") + "\t\t" + rs.getTime("departure_time");
				flightInfo.add(rs.getString("flight_id"));
				flightInfo.add(rs.getString("flight_name"));
				flightInfo.add(rs.getString("source"));
				flightInfo.add(rs.getString("destination"));
				flightInfo.add(rs.getString("arrival_time"));
				flightInfo.add(rs.getString("departure_time"));
				flightInfo.add("\n");
				
			}
			return flightInfo;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}