package com.restful.electronicshopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.restful.electronicshopping.dao.DAOImplementation;
import com.restful.electronicshopping.entity.Product;
//import com.restful.electronicshopping.entity.Response;
import com.restful.electronicshopping.exception.ServiceException;
import com.sun.xml.bind.util.Which;


@Path("/sellerapp")
public class SellerApplicationServiceImplementation /*extends HttpServlet*/ implements SellerApplicationServiceInterface {

	//private static final long serialVersionUID = 1L;

	@Override
	@POST
	@Path("/add")
	@Produces({"application/xml"})
	@Consumes({"application/xml"})
	public Response addProduct(Product p) throws ServiceException{

		String result = "Error Adding Data";
		System.out.println("doqiwdoqwidh" + p.getCurrentstocknumbers());
		try {
			DAOImplementation daoimp = new DAOImplementation();
			daoimp.addProduct(p);
			result = "Product '"  + p.getProductName() + "' have been added Added";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return Response.status(Status.NOT_MODIFIED).entity(result).build();
		}
		return Response.status(Status.CREATED).entity(result).build();	
	}

	@Override
	public Response deleteProduct(int ProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@POST
	@Path("/getProdutDetails_ID")
	@Consumes({"application/xml"})
	@Produces({"application/xml"})
	public Response getDetailsofOneProduct(Product P)  {
		
		Product result = null;
		try {
			DAOImplementation daoim = new DAOImplementation();
			 result = daoim.getDetailsofOneProduct(P.getProductID());
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return  Response.status(Status.OK).entity(result).build();
	}

	@Override
	@GET
	@Path("/getAllProdutDetails")
	@Produces({"application/xml"})
	public ArrayList<Product> getDetailsofAllProduct() {
		DAOImplementation daoim = new DAOImplementation();
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			productList = daoim.getDetailsofAllProduct();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Product prod : productList) {
			System.out.println("-------=======" + prod.getProductName());
		}
		return productList;
	}
}