package com.dong.domain;

public class Admin {
	private Integer AdminId;
	private String userName;
	private String password;
	
	public Admin() {
		
	}
	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", userName=" + userName + ", password=" + password + "]";
	}
	public Integer getAdminId() {
		return AdminId;
	}
	public void setAdminId(Integer adminId) {
		AdminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
