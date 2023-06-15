package test;

import dao.CategoryDAOImpl;
import entities.Category;

public class AddTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Category c = new Category();
		c.setCateName("OK");
		c.setCateId(10);
		boolean check = new CategoryDAOImpl().insertClass(c);
		
		System.out.println(check);
	}

}
