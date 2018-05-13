package com.restful.electronicshopping.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
	@Path("/test")
	@Produces({"application/xml"})
	//@Consumes({"application/xml"}) 
	public Response addProduct1( /*@FormParam("p") Product p*/@FormParam("productName") String productName,
		      @FormParam("productCategory") String productCategory,
		      @FormParam("price") double price,
		      @FormParam("currentStockNumbers") int currentStockNumbers,
		      @FormParam("remarks") String remarks
		      ) throws ServiceException{
		Product p = new Product(productName, productCategory, price, currentStockNumbers, remarks);

		String result = "Error Adding Data";
		System.out.println("doqiwdoqwidh" + p.getCurrentStockNumbers());
		try {
			DAOImplementation daoimp = new DAOImplementation();
			daoimp.addProduct(p);
			result = "Product '"  + p.getProductName() + "' have been added Added";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return Response.status(Status.NOT_MODIFIED).entity(result).build();
		}
		return Response.status(200).entity(result).build();	
	}
	
	@Override
	@POST
	@Path("/add")
	@Produces({"application/xml"})
	@Consumes({"application/xml"}) 
	public Response addProduct(Product p) throws ServiceException{
		//Product p = new Product(productName, productCategory, price, currentStockNumbers, remarks);

		String result = "Error Adding Data";
//		System.out.println("doqiwdoqwidh" + p.getCurrentstocknumbers());
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
	@POST
	@Path("/delete")
	@Produces({"application/xml"})
	@Consumes({"application/xml"})
	public Response deleteProduct(Product p) throws ServiceException {
		boolean result = false;
		try {
			DAOImplementation daoimp = new DAOImplementation();
			result = daoimp.deleteProduct(p.getProductID());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(result == true)
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.NOT_MODIFIED).build();
	}

	@Override
	@POST
	@Path("/getProdutDetailsByID")
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
//			System.out.println("-------=======" + prod.getProductName());
		}
		return productList;
	}

	@Override
	@POST
	@Path("/update")
	@Consumes({"application/xml"})
	@Produces({"application/xml"})
	public Response updateProduct(Product p) throws ServiceException, ClassNotFoundException, SQLException {
		boolean result = false;
		try {
			DAOImplementation daoimp = new DAOImplementation();
			result = daoimp.updateProductDetails(p);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(result == true)
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.NOT_MODIFIED).build();
	}
}