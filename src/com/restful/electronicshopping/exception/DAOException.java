package com.restful.electronicshopping.exception;

import java.sql.SQLException;

public class DAOException extends SQLException{

	public DAOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DAOException(String reason, String sqlState, int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String reason, String SQLState, int vendorCode) {
		super(reason, SQLState, vendorCode);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String reason, String sqlState, Throwable cause) {
		super(reason, sqlState, cause);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String reason, String SQLState) {
		super(reason, SQLState);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String reason, Throwable cause) {
		super(reason, cause);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

	public DAOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
