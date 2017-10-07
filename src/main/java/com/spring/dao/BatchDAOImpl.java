package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.model.Batch;
import com.spring.model.Login;

public class BatchDAOImpl implements BatchDAO {
	private SessionFactory sessionFactory;
	

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void save(Batch batch) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(batch);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Batch> batchList() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Batch> batchList = session.createQuery("From Batch").list();
		session.close();
		return batchList;
		
	}

	@Override
	public void updateBatch(Batch batch) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	session.update(batch);
	session.close();
		
	}

	@Override
	public void deleteBatch(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Batch batch = (Batch) session.load(Batch.class, new Integer(id));
		//list<Student> student=(Studemt ) session.load(Batch.class, new Integer(id));
		if(null != batch){
			session.delete(batch);
		}
		
	}

	@Override
	public Batch getByBatchID(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Batch batch = (Batch) session.load(Batch.class, new Integer(id));
		return batch;
	}

}
