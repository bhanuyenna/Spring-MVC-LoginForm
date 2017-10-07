package com.spring.dao;

import java.util.List;

import com.spring.model.Login;

public interface LoginDAO {

public void save(Login login);
	
	public List<Login> list();
	public Login validateUser(Login login);
}
