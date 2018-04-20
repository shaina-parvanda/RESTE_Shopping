package com.restful.electronicshopping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.restful.electronicshopping.entity.*;

public interface DAOInterface {

	public boolean checkConnection();
	
	public void addProduct(Product p) throws ClassNotFoundException, SQLException;
	public Response updateProductDetails(Product p) throws SQLException, ClassNotFoundException;
	public Response deleteProduct(int ProductId) throws ClassNotFoundException, SQLException;
	public ResultSet getDetailsofOneProduct(int ProductId) throws ClassNotFoundException, SQLException;
	public ResultSet getDetailsofAllProduct() throws ClassNotFoundException, SQLException;

}
