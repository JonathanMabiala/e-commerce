package com.sportyshoes.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.RoleDAO;
import com.sportyshoes.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	
	@Override
	@Transactional
	public Role findByRole(Role role) {
		
		return null;
	}

	@Override
	@Transactional
	public void saveRole(Role role) {
		roleDAO.saveRole(role);
	}

}
