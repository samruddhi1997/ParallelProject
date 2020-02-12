package com.capgemini.airlinereservationsystem.service.impl;



import com.capgemini.airlinereservationsystem.dao.impl.CustomerDetailsDaoImpl;
import com.capgemini.airlinereservationsystem.dto.CustomerDetailsDto;

public class CustomerDetailsService  {
	public static String searchForm(int customerId) {
		CustomerDetailsDto add = new CustomerDetailsDto();
		add.setCustomer_id(customerId);

		CustomerDetailsDaoImpl cdd = new CustomerDetailsDaoImpl();
		String res = cdd.searchForm();

		return res;
	}

	
	
}
