package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.beans.Login;
import com.revature.data.LoginDao;

@Component
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

	
}
