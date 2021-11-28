package com.sportyshoes.dao;

import com.sportyshoes.entity.Role;


public interface RoleDAO   {
	
	public Role findByRole(String role );
	public void saveRole(Role role );
}
