package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Login;
import com.revature.data.LoginDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	LoginDao ld;
	@Override
	public Login login(String username, String password) {
		Login user = ld.getByPass(username, password);
		
		return user;
	}
	@Override
	public Login addUser(Login login) {
		return ld.save(login);
	}

	@Override
	public Login update(Login login) {
		return ld.update(login);
	}
	
	@Override
	public List<Login> listAll() {
		return ld.list();
	}
}
