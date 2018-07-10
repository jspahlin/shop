package com.revature.services;

import java.util.List;

import com.revature.beans.Login;

public interface UserService {
	public Login login(String user, String pass);
	public Login addUser(Login login);
	public Login update(Login user);
	public List<Login> listAll();
}
