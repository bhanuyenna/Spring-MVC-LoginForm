package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.model.Student;

public class StudentDAOImpl implements StudentDAO {
private SessionFactory sessionFactory;
	

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void save(Student student) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();
	}

	@Override
	public void updateStudent(Student student) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	session.update(student);
	session.close();
	}

	@Override
	public void deleteStudent(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.load(Student.class, new Integer(id));
		//list<Student> student=(Studemt ) session.load(Batch.class, new Integer(id));
		if(null != student){
			session.delete(student);
		}
	}

	@Override
	public List<Student> studentList() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Student> studentList = session.createQuery("From Student").list();
		session.close();
		return studentList;
	}

	@Override
	public Student getByStudentID(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.load(Student.class, new Integer(id));
		return student;
	}

}
