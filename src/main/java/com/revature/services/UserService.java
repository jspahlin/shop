package com.revature.services;

import com.revature.beans.Login;

public interface UserService {
	public Login login(String user, String pass);
}
