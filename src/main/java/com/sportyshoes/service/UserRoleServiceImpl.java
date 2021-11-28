package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.UserRoleDAO;
import com.sportyshoes.entity.UserRole;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Override
	public List<UserRole> getUserRoles() {
		//Get all roles
		return userRoleDAO.getUserRoles();
	}

}
