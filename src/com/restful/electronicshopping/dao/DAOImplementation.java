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
		System.out.println("<><><><>"+p.getCurrentStockNumbers() + "<><><><>" + p.getRemarks());
		try {
			add_stmnt.setLong(1, p.getProductID());
			add_stmnt.setString(2, p.getProductName());
			add_stmnt.setString(3, p.getProductCategory());
			add_stmnt.setLong(4, (long) p.getPrice());
			add_stmnt.setInt(5, p.getCurrentStockNumbers());
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
	public boolean updateProductDetails(Product p) throws SQLException, ClassNotFoundException {
		String sql_str = null;
		sql_str = "UPDATE product_details SET product_name = '" +  p.getProductName() + "', productCategory = '" + p.getProductCategory() 
		+ "', price = " + String.valueOf(p.getPrice()) + ", currentStockNumbers = " + String.valueOf(p.getCurrentStockNumbers()) + ", remarks = '" + p.getRemarks() + "' WHERE product_id = " + String.valueOf(p.getProductID()) + ";";

		boolean result = false;
		try {
			DAOConfiguration.establishConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement fetchdetails = DAOConfiguration.getCn().createStatement();
			fetchdetails.execute(sql_str);
			result = true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DAOConfiguration.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteProduct(int ProductId) throws ClassNotFoundException, SQLException {
		String sql_str = null;
		sql_str = "DELETE FROM product_details WHERE product_id = " + String.valueOf(ProductId) +";";
		ResultSet rs = null ;
		boolean result = false;
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
			result = true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DAOConfiguration.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
			p.setCurrentStockNumbers(rs.getInt(5));
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
			Product p = new Product();
			p.setProductID(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setProductCategory(rs.getString(3));
			p.setPrice(rs.getDouble(4));
			p.setCurrentStockNumbers(rs.getInt(5));
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

	@Override
    public ArrayList<Product> getProductsByCategory(String ProductCategory) throws DAOException {
          String sql_str = null;
          sql_str = "SELECT * FROM product_details WHERE productCategory = '" + ProductCategory +"';";
          ResultSet rs = null ;
          
          ArrayList<Product> products = new ArrayList<Product>();
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
          try {
                 while(rs.next()) {
                	 Product p = new Product();
                     p.setProductID(rs.getInt(1));
                     p.setProductName(rs.getString(2));
                     p.setProductCategory(rs.getString(3));
                     p.setPrice(rs.getDouble(4));
                     p.setCurrentStockNumbers(rs.getInt(5));
                     p.setRemarks(rs.getString(5));
                     products.add(p);
                 }
          } catch (SQLException e1) {
                 // TODO Auto-generated catch block
                 e1.printStackTrace();
          }
          try {
                 DAOConfiguration.closeConnection();
          } catch (SQLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
          }
          return products;
    }


	@Override
	public ArrayList<Product> getProductsByPriceRange(int low, int high) throws DAOException {
		String sql_str = null;
        sql_str = "select * from product_details where price between " + String.valueOf(low) + " and " + String.valueOf(high) + ";";
        ResultSet rs = null ;
        ArrayList<Product> products = new ArrayList<Product>();
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
        try {
               while(rs.next()) {
            	   Product p = new Product();
                   p.setProductID(rs.getInt(1));
                   p.setProductName(rs.getString(2));
                   p.setProductCategory(rs.getString(3));
                   p.setPrice(rs.getDouble(4));
                   p.setCurrentStockNumbers(rs.getInt(5));
                   p.setRemarks(rs.getString(5));
                   products.add(p);
               }
        } catch (SQLException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
        }
        try {
               DAOConfiguration.closeConnection();
        } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        return products;
	}

	@Override
	public boolean buyProduct(int productID) throws SQLException {
		String sql_str = null;
		sql_str = "SELECT * FROM product_details WHERE product_id = " + String.valueOf(productID) +";";
		ResultSet rs = null ;
		Product p = new Product();
		boolean result = false;
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
			p.setCurrentStockNumbers(rs.getInt(5));
			p.setRemarks(rs.getString(5));
		}
		try {
			DAOConfiguration.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("blah ------ " + p.getProductID());
		
		if(p.getCurrentStockNumbers() > 0) {
			sql_str = "UPDATE product_details SET product_name = '" +  p.getProductName() + "', productCategory = '" + p.getProductCategory() 
			+ "', price = " + String.valueOf(p.getPrice()) + ", currentStockNumbers = " + String.valueOf(p.getCurrentStockNumbers() - 1) + ", remarks = '" + p.getRemarks() + "' WHERE product_id = " + String.valueOf(p.getProductID()) + ";";

			try {
				DAOConfiguration.establishConnection();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Statement fetchdetails = DAOConfiguration.getCn().createStatement();
				fetchdetails.execute(sql_str);
				result = true;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				DAOConfiguration.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}