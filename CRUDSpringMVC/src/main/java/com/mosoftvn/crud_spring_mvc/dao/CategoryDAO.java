package com.mosoftvn.crud_spring_mvc.dao;

import java.util.List;

import com.mosoftvn.crud_spring_mvc.entities.Category;

public interface CategoryDAO {
	public List<Category> getAll();
	public Boolean create(Category category);
	public Category find(Integer categoryID);
	public Boolean update(Category category);
	public Boolean delete(Integer categoryID);
}
