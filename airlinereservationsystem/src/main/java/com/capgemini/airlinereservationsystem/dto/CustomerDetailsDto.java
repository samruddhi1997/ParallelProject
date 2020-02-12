package com.capgemini.airlinereservationsystem.dto;

import java.sql.Date;

public class CustomerDetailsDto {
	private static int customerId;
	private static String customerName;
	private static String password;
	private static Date dob;
	private static long phoneNumber;
	private static String email;
	private static String govtId;
	private static String gender;
	private static String nationality;

	public static int getCustomerId() {
		return customerId;
	}

	public void setCustomer_id(int customerId) {
		CustomerDetailsDto.customerId = customerId;
	}

	public static String getCustomerName() {
		return customerName;
	}

	public void setCustomer_name(String customerName) {
		CustomerDetailsDto.customerName = customerName;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		CustomerDetailsDto.password = password;
	}

	public static Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		CustomerDetailsDto.dob = dob;
	}

	public static long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhone_number(long phoneNumber) {
		CustomerDetailsDto.phoneNumber = phoneNumber;
	}

	public static String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		CustomerDetailsDto.email = email;
	}

	public static String getGovtId() {
		return govtId;
	}

	public void setGovt_id(String govtId) {
		CustomerDetailsDto.govtId = govtId;
	}

	public static String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		CustomerDetailsDto.gender = gender;
	}

	public static String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		CustomerDetailsDto.nationality = nationality;
	}

}
