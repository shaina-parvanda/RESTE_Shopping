package com.restful.electronicshopping.service;

import com.restful.electronicshopping.entity.Response;
import com.restful.electronicshopping.exception.ServiceException;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.restful.electronicshopping.entity.Product;;

public interface SellerApplicationServiceInterface {

	public void addProduct(Product p) throws ServiceException;

	public Response deleteProduct(int ProductId) throws ServiceException;

	public ResultSet getDetailsofOneProduct(int ProductId) throws ServiceException, ClassNotFoundException, SQLException;

	public ResultSet getDetailsofAllProduct() throws ServiceException, ClassNotFoundException, SQLException;
}
