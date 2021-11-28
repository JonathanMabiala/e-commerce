package com.sportyshoes.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="auth_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auth_user_id")
	private int id;
	
	@NotNull(message="First name is required")
	@Column(name = "first_name")
	private String name;

	@NotNull(message="Last name is required")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message="Email is required")
	@Column(name = "email")
	@Email(message="Email is invalid")
	private String email;

	@NotNull(message="password isrequired")
	
	@Length(min=5, message="Password should be at least 5 characters")
	@Column(name = "password")
	private String password;
	
	@Transient
	private String newPassword;

	@Column(name = "status")
	private String status;
	
	@Column(name = "role_id")
	private int roleId;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	
	
	public String getNewPassword() {
		return newPassword;
	}

	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", status=" + status + ", roleId=" + roleId + ", roles=" + roles + "]";
	}
	

}
