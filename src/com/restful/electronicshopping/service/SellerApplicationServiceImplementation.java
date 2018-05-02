package com.restful.electronicshopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.MediaType;

import com.restful.electronicshopping.dao.DAOImplementation;
import com.restful.electronicshopping.entity.Product;
//import com.restful.electronicshopping.entity.Response;
import com.restful.electronicshopping.exception.ServiceException;


@Path("/sellerapp")
/*@Consumes({"application/xml"})
@Produces({"application/xml"})*/
//@WebServlet("/sellerapplication")
public class SellerApplicationServiceImplementation /*extends HttpServlet*/ implements SellerApplicationServiceInterface {

	//private static final long serialVersionUID = 1L;
	
	@Override
	@POST
    @Path("/add")
	@Produces({"application/xml"})
	@Consumes({"application/xml"})
	public Response addProduct(Product p) throws ServiceException{
		
		System.out.println("-------ADD-------"+p.getProductName());
		String result = "Object Added : " + p;
		/*try {
			DAOImplementation daoimp = new DAOImplementation();
			daoimp.addProduct(p);
			System.out.println("---------------"+p.getPrice());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}*/
		return Response.status(201).entity(result).build();	
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