package dao;

import java.util.List;

import entities.Category;

public interface CategoryDAO {
	
	public List<Category> getCategory();
	public boolean insertClass(Category category);
	public boolean updateClass(Category category);
	public boolean deleteClass(Integer categoryId);
	public Category getClassById(Integer categoryId);
	public List<Category> getClassesByName(String categoryName);
}
