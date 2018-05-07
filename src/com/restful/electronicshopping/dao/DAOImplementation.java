package com.restful.electronicshopping.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.spi.DirStateFactory.Result;

import com.restful.electronicshopping.dao.*;
import com.restful.electronicshopping.entity.Product;
import com.restful.electronicshopping.entity.Response;

import com.restful.electronicshopping.exception.*;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;


/**
 * @author Shaina Parvanda
 *
 */
public class DAOImplementation implements DAOInterface{

	@Override
	public boolean checkConnection() {
		try {
			DAOConfiguration.establishConnection();
			DAOConfiguration.closeConnection();
			return true;
		} catch (ClassNotFoundException e) {
			//System.out.println("No class!!!!!!!");
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public void addProduct(Product p) throws ClassNotFoundException, SQLException {
		try {
			System.out.println("attempting to establish connection");
			DAOConfiguration.establishConnection();
			System.out.println("connection established");
		} catch (ClassNotFoundException e) {
			throw new DAOException("You have no such class");
		}
		catch (SQLException e1) {
			throw new DAOException(e1.getMessage());
		}
		String sql_string = "INSERT INTO product_details VALUES ( ? , ? , ? , ? , ? , ? );";
		
		PreparedStatement add_stmnt = null;
		try {
			add_stmnt = DAOConfiguration.getCn().prepareStatement(sql_string);
	
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		System.out.println("<><><><>"+p.getCurrentstocknumbers() + "<><><><>" + p.getRemarks());
		try {
			add_stmnt.setLong(1, p.getProductID());
			add_stmnt.setString(2, p.getProductName());
			add_stmnt.setString(3, p.getProductCategory());
			add_stmnt.setLong(4, (long) p.getPrice());
			add_stmnt.setInt(5, p.getCurrentstocknumbers());
			add_stmnt.setString(6, p.getRemarks());
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		try {
			add_stmnt.executeUpdate();
			add_stmnt.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Response updateProductDetails(Product p) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteProduct(int ProductId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getDetailsofOneProduct(int ProductId) throws ClassNotFoundException, SQLException {
		String sql_str = null;
		sql_str = "SELECT * FROM product_details WHERE product_id = " + String.valueOf(ProductId) +";";
		ResultSet rs = null ;
		Product p = new Product();
		try {
			DAOConfiguration.establishConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement fetchdetails = DAOConfiguration.getCn().createStatement();
			fetchdetails.execute(sql_str);
			 rs =fetchdetails.getResultSet();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(rs.next()) {
		    p.setProductID(rs.getInt(1));
		    p.setProductName(rs.getString(2));
		    p.setProductCategory(rs.getString(3));
		    p.setPrice(rs.getDouble(4));
		    p.setCurrentstocknumbers(rs.getInt(5));
		    p.setRemarks(rs.getString(5));
		}
		try {
			DAOConfiguration.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public ArrayList<Product> getDetailsofAllProduct() throws ClassNotFoundException, SQLException {
		String sql_string = "SELECT * FROM product_details pd;";
		ResultSet rs = null ;
		Product p = new Product();
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			DAOConfiguration.establishConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement fetch_all = DAOConfiguration.getCn().createStatement();
			fetch_all.execute(sql_string);
			 rs =fetch_all.getResultSet();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(rs.next()) {
			p.setProductID(rs.getInt(1));
		    p.setProductName(rs.getString(2));
		    p.setProductCategory(rs.getString(3));
		    p.setPrice(rs.getDouble(4));
		    p.setCurrentstocknumbers(rs.getInt(5));
		    p.setRemarks(rs.getString(5));
		    productList.add(p);
		}
		try {
			DAOConfiguration.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
}