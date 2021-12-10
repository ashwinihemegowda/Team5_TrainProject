package com.torryharris.service;

import com.torryharris.DAO.UserDAO;
import com.torryharris.model.UserRegDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO repo;
	
	@Override
	public boolean registerUser(UserRegDTO user) {
		return repo.registerUser(user) > 0 ? true : false;
	}

}
