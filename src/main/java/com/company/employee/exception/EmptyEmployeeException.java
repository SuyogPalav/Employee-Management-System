package com.company.employee.exception;

public class EmptyEmployeeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyEmployeeException(String message) {
		super(message);
	}

}
