package dao;

import java.util.List;

import org.hibernate.Session;

import entities.Category;
import hibernate.util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Category").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public boolean insertClass(Category category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateClass(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClass(Integer categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category getClassById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getClassesByName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
