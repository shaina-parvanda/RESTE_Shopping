package com.restful.electronicshopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restful.electronicshopping.dao.DAOImplementation;
import com.restful.electronicshopping.entity.Product;
import com.restful.electronicshopping.entity.Response;
import com.restful.electronicshopping.exception.ServiceException;


@Path("/sellerapp")
@Consumes(MediaType.APPLICATION_XML)
//@Produces(MediaType.APPLICATION_XML)
//@WebServlet("/sellerapplication")
public class SellerApplicationServiceImplementation /*extends HttpServlet */implements SellerApplicationServiceInterface {

	private static final long serialVersionUID = 1L;
	
	@Override
	@POST
    @Path("/add")
	public void addProduct(Product p) throws ServiceException{
		try {
			DAOImplementation daoimp = new DAOImplementation();
			daoimp.addProduct(p);
			System.out.println("---------------"+p.getPrice());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Response deleteProduct(int ProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getDetailsofOneProduct(int ProductId) throws ClassNotFoundException, SQLException {
		DAOImplementation daoim = new DAOImplementation();
		ResultSet result = null;
		daoim.getDetailsofOneProduct(ProductId);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ResultSet getDetailsofAllProduct() throws ClassNotFoundException, SQLException {
		DAOImplementation daoim = new DAOImplementation();
		ResultSet result = null;
		daoim.getDetailsofAllProduct();
		// TODO Auto-generated method stub
		return result;
	}
}