package com.spring.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.StudentDAO;
import com.spring.dao.StudentDAOImpl;
import com.spring.model.Student;


@Controller
public class StudentController {
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public String student(Model model) {
		model.addAttribute("msg", "Please Enter Your Student Details");
		System.out.println("we are in student jsp");
		return "student";
	}
	@SuppressWarnings("resource")
	@RequestMapping(value="/student/{id}/studentSave", method = RequestMethod.POST)
	public String saveStudent(Model model, @ModelAttribute("student") Student student,@PathVariable("id") String id){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Student currentStudent = new Student();
		StudentDAO StudentDAO= context.getBean(StudentDAO.class);
		currentStudent.setBatchId(id);
		currentStudent.setStudentName(student.getStudentName());
		currentStudent.setEmail(student.getEmail());
		currentStudent.setVisaStatus(student.getVisaStatus());
		currentStudent.setContact(student.getContact());
		currentStudent.setPaid(student.getPaid());
		currentStudent.setMode(student.getMode());
		currentStudent.setCost(student.getCost());
		currentStudent.setComments(student.getComments());
		StudentDAO.save(currentStudent);
		List<Student> list = 	StudentDAO.studentList();
		for (Student p : list) {
			System.out.println("Student List::" + p);
		}
		model.addAttribute("msg", list); 
		
		context.close();
		
		return "studentSuccess";

	}
	
	@RequestMapping(value = "/updateStudent/{StudentId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updatePerson(@PathVariable("id") int id, @RequestBody Student student) {
		StudentDAOImpl b= new StudentDAOImpl();
		
		Student currentStudent = b.getByStudentID(id);
		currentStudent.setBatchId(student.getBatchId());
		currentStudent.setStudentName(student.getStudentName());
		currentStudent.setEmail(student.getEmail());
		currentStudent.setVisaStatus(student.getVisaStatus());
		currentStudent.setContact(student.getContact());
		currentStudent.setPaid(student.getPaid());
		currentStudent.setMode(student.getMode());
		currentStudent.setCost(student.getCost());
		currentStudent.setComments(student.getComments());
		
		b.updateStudent(currentStudent);
		
		return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
	}

	@RequestMapping(value = "/removeStudent/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
		StudentDAOImpl b= new StudentDAOImpl();
		Student updateStudent = b.getByStudentID(id);
		b.deleteStudent(id);
		return new ResponseEntity<Student>(updateStudent, HttpStatus.NO_CONTENT);

	}

}
