package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.model.Login;

public class LoginDAOImpl implements LoginDAO {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(Login p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	public List<Login> list() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Login> employeeList = session.createQuery("From Login").list();
		session.close();
		//employeeList.contains("rajesh");
		return employeeList;
	}

	@Override
	public Login validateUser(Login login) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		String username =login.getUserName();
		String password =login.getPassword();
		String sql=" From Login l where l.userName='"+username+"' and l.password='"+password+"'";
		System.out.println("SQL Query is ---------------->"+sql);
		List<Login> employeeList = session.createQuery(sql).list();
		return employeeList.size() > 0 ? employeeList.get(0) : null;

	}

}
