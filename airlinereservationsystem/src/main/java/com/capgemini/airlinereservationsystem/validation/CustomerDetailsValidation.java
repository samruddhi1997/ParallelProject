package com.capgemini.airlinereservationsystem.validation;


import com.capgemini.airlinereservationsystem.dao.impl.CustomerDetailsDaoImpl;
import com.capgemini.airlinereservationsystem.dto.CustomerDetailsDto;

public class CustomerDetailsValidation {

	CustomerDetailsDto dto = new CustomerDetailsDto();

	public static String customerValidation() {

		CustomerDetailsDaoImpl impl = new CustomerDetailsDaoImpl();

		String s1 = impl.searchForm();
		String s2 = s1.toUpperCase();

		return s2;
	}
}
