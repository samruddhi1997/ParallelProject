package com.capgemini.airlinereservationsystem.exception;

public class DatabaseConnectivityException extends RuntimeException {

	String msg = "Database Connection Unsuccessfull";

	public DatabaseConnectivityException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}