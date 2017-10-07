package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.BatchDAO;
import com.spring.dao.LoginDAO;
import com.spring.model.Batch;
import com.spring.model.Login;

@Controller
public class LoginController {
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@SuppressWarnings("resource")
	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("login") Login login) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Login loginUser = new Login();
		LoginDAO loginDAO = context.getBean(LoginDAO.class);
		List<Login> list = loginDAO.list();
		loginUser.setUserName(login.getUserName());
		loginUser.setPassword(login.getPassword());
		loginUser.setEmail(login.getEmail());
		loginUser.setFirstName(login.getFirstName());
		loginUser.setLastName(login.getLastName());
		loginUser.setCreatedDate(login.getCreatedDate());
		loginUser.setUpdatedDate(login.getUpdatedDate());

		loginDAO.save(loginUser);
		System.out.println("Person::" + loginUser);

		for (Login p : list) {
			System.out.println("Person List::" + p);
		}

		// model.addAttribute("msg", loginUser.getUserName());

		context.close();

		return "login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		BatchDAO batchDAO = context.getBean(BatchDAO.class);
		LoginDAO loginDAO = context.getBean(LoginDAO.class);
		Login loginUser = loginDAO.validateUser(login);
		List<Batch> list = batchDAO.batchList();
		
		if(loginUser.isAdmin()){
			Batch b = new Batch();	
			b.setAdmin(true);
			list.add(b);
		}
		
		
		if (null != loginUser) {
			model.addAttribute("msg", list);
			return "batchsuccess";

		}

		return "login";
	}

}
