package com.sportyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="auth_user_role")
public class UserRole {
	
	@Id
	@Column(name = "auth_user_id")
	private int userId;
	
	@Column(name = "auth_role_id")
	private int roleId;
	
	
	

	public UserRole() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	

}
