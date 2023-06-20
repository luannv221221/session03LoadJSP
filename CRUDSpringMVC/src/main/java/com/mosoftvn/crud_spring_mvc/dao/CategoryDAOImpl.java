package com.mosoftvn.crud_spring_mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mosoftvn.crud_spring_mvc.entities.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
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
	public Boolean create(Category category) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Category find(Integer categoryID) {
		Session session = sessionFactory.openSession();
		try {
			Category category = session.get(Category.class,categoryID);
			return category;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean delete(Integer categoryID) {
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.delete(find(categoryID));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean update(Category category) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

}
