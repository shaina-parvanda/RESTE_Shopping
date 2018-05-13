package com.restful.electronicshopping.service;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.restful.electronicshopping.entity.PriceRange;
import com.restful.electronicshopping.entity.Product;
import com.restful.electronicshopping.exception.ServiceException;

public interface BuyerApplicationServiceInterface {

    public ArrayList<Product> getProductsByCategory(Product p) throws ServiceException;
    public ArrayList<Product> getProductsByPriceRange(Product p) throws ServiceException;
    public Response buyProduct(Product p) throws ServiceException;

}
