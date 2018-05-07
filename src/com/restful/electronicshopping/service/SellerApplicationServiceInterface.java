package com.restful.electronicshopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.restful.electronicshopping.entity.Product;
//import com.restful.electronicshopping.entity.Response;
import com.restful.electronicshopping.exception.ServiceException;

import javax.ws.rs.core.Response;
public interface SellerApplicationServiceInterface {

	public Response addProduct(Product p) throws ServiceException;

	public Response deleteProduct(int ProductId) throws ServiceException;

	public Response getDetailsofOneProduct(Product P) throws ServiceException, ClassNotFoundException, SQLException;

	public ArrayList<Product> getDetailsofAllProduct() throws ServiceException, ClassNotFoundException, SQLException;
}
