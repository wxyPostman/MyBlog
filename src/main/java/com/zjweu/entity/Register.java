package com.zjweu.entity;

public class Register {
	private Integer id;

	private String phone;

	private String password;

	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", phone=" + phone + ", password=" + password + ", username=" + username + "]";
	}

}