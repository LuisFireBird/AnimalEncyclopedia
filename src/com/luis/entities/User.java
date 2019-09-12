package com.luis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table(name = "usuarios")
@Entity
public class User {
	
	@Id
	@Column(name = "username")
	@NotBlank(groups = {UserFormValidationGroup.class, UserPersistanceValidationGroup.class})
	@Size(min = 5, max = 10, groups = {UserFormValidationGroup.class, UserPersistanceValidationGroup.class})
	@Pattern(regexp = "^\\w+", groups = {UserFormValidationGroup.class, UserPersistanceValidationGroup.class})
	private String userName;

	@Column(name = "password")
	@NotBlank(groups = {UserFormValidationGroup.class, UserPersistanceValidationGroup.class})
	@Size(min = 5, max = 10, groups = {UserFormValidationGroup.class})
	private String passWord;

	@Column(name = "role")
	private String role;

	@Column(name = "enabled")
	private int enabled;
	
	public User() {
		
	}

	public User(String userName, String passWord, String role, int enabled) {
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
		this.enabled = enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
