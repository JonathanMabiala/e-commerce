package com.sportyshoes.service;

import com.sportyshoes.entity.Role;

public interface RoleService {

	public Role findByRole(Role role);
	
	public void saveRole(Role role);
}
