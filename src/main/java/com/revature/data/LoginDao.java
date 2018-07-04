package com.revature.data;

import java.util.List;

import com.revature.beans.Login;

public interface LoginDao {
	public Login get(int id);
	public Login getByPass(String username, String password);
	public Login save(Login user);
	public Login update(Login user);
	public void delete(Login user);
	public List<Login> list();
}

	

