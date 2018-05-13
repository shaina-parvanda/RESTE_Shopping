package com.restful.electronicshopping.service;

import java.awt.PageAttributes.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.restful.electronicshopping.dao.DAOImplementation;
import com.restful.electronicshopping.entity.PriceRange;
import com.restful.electronicshopping.entity.Product;
import com.restful.electronicshopping.exception.ServiceException;

@Path("/buyerapp")
public class BuyerApplicationServiceImplementation implements BuyerApplicationServiceInterface{

	@Override
	@POST
	@Path("/getProductByCateory")
	@Produces({"application/json"})
	public ArrayList<Product> getProductsByCategory(Product p) throws ServiceException {
		DAOImplementation daoim = new DAOImplementation();
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			products = daoim.getProductsByCategory(p.getProductCategory());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Product prod : products) {
//			System.out.println("-------=======" + prod.getProductName());
		}
		return products;
	}

	@Override
	@POST
	@Path("/getProductByPriceRange")
	@Produces({"application/json"})
//	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public ArrayList<Product> getProductsByPriceRange(Product p) throws ServiceException {
		DAOImplementation daoim = new DAOImplementation();
		ArrayList<Product> products = new ArrayList<Product>();
		System.out.println("---------" + p.getPriceMin() + "========" + p.getPriceMax() + "------------");
		try {
			products = daoim.getProductsByPriceRange(p.getPriceMin(), p.getPriceMax());
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		for(Product prod : products) {
////			System.out.println("-------=======" + prod.getProductName());
//		}
		return products;
	}

	@Override
	@POST
	@Path("/buyProduct")
	@Produces({"application/json"})
	public Response buyProduct(Product p) throws ServiceException {
		boolean result = false;
		try {
			DAOImplementation daoim = new DAOImplementation();
			 result = daoim.buyProduct(p.getProductID());
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		if(result == true)
			return  Response.status(Status.OK).build();
		else
			return  Response.status(Status.BAD_REQUEST).build();
	}

}
