package test;

import java.util.List;

import dao.CategoryDAOImpl;
import entities.Category;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Category> list = new CategoryDAOImpl().getCategory();
		
		for (Category category : list) {
			System.out.println(category.getCateName());
		}
	}

}
