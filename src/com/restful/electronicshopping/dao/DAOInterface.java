package com.restful.electronicshopping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.restful.electronicshopping.entity.*;
import com.restful.electronicshopping.exception.DAOException;

public interface DAOInterface {

	public boolean checkConnection();
	
	public void addProduct(Product p) throws ClassNotFoundException, SQLException;
	public boolean updateProductDetails(Product p) throws SQLException, ClassNotFoundException;
	public boolean deleteProduct(int ProductId) throws ClassNotFoundException, SQLException;
	public Product getDetailsofOneProduct(int ProductId) throws ClassNotFoundException, SQLException;
	public ArrayList<Product> getDetailsofAllProduct() throws ClassNotFoundException, SQLException;
	
	
	public ArrayList<Product> getProductsByCategory(String ProductCategory) throws DAOException;
    public ArrayList<Product> getProductsByPriceRange(int high, int low) throws DAOException;
    public boolean buyProduct(int productID) throws DAOException, SQLException;


}
