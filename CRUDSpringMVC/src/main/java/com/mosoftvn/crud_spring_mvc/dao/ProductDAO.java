package com.mosoftvn.crud_spring_mvc.dao;

import java.util.List;


import com.mosoftvn.crud_spring_mvc.entities.Product;

public interface ProductDAO {
	public List<Product> getAll();
	public Boolean create(Product product);
	public Product find(Integer productID);
	public Boolean update(Product product);
	public Boolean delete(Integer productID);
}
