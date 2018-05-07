package com.restful.electronicshopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shaina Parvanda
 *
 */
public class DAOConfiguration {

	protected static Connection cn;

	private final static String url = "jdbc:mysql://localhost:3306/product_details";
	private final static String username = "root";
	private final static String password = "password123"; 

	public static void establishConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url, username, password);
	}
	/**
	 * @return the cn
	 */
	public static Connection getCn() {
		return cn;
	}
	/**
	 * @param cn the cn to set
	 */
	public static void setCn(Connection cn) {
		DAOConfiguration.cn = cn;
	}
	public static void closeConnection() throws SQLException {
		cn.close();
	}
}
