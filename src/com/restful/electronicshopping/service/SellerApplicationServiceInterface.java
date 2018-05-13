package com.restful.electronicshopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.restful.electronicshopping.entity.Product;
//import com.restful.electronicshopping.entity.Response;
import com.restful.electronicshopping.exception.ServiceException;

import javax.ws.rs.core.Response;
public interface SellerApplicationServiceInterface {

	/*public Response addProduct(String productName, String productCategory, double price, int currentStockNumbers,
			String remarks) throws ServiceException;*/

	public Response deleteProduct(Product p) throws ServiceException;

	public Response getDetailsofOneProduct(Product P) throws ServiceException, ClassNotFoundException, SQLException;

	public ArrayList<Product> getDetailsofAllProduct() throws ServiceException, ClassNotFoundException, SQLException;
	
	public Response updateProduct(Product P) throws ServiceException, ClassNotFoundException, SQLException;

	public Response addProduct(Product p) throws ServiceException;

	//public Response addProduct1(Product p) throws ServiceException;

	public Response addProduct1(String productName, String productCategory, double price, int currentStockNumbers,
			String remarks) throws ServiceException;

}
