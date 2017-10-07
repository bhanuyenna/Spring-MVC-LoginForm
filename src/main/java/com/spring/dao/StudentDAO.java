package com.spring.dao;

import java.util.List;

import com.spring.model.Student;

public interface StudentDAO {
	public void save(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int id);

	public List<Student> studentList();

	public Student getByStudentID(int id);

}
