package com.dong.domain;

public class Student {
	private Integer studentId;
	private String stuNumber;
	private String userName;
	private String password;
	private Integer dormBuildId = 0;
	private String dormBuildName;
	private String dormName;
	
	private String sex;
	private String tel;
	
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", stuNumber=" + stuNumber + ", userName=" + userName + ", password="
				+ password + ", dormBuildId=" + dormBuildId + ", dormBuildName=" + dormBuildName + ", dormName="
				+ dormName + ", sex=" + sex + ", tel=" + tel + "]";
	}

	public Student() {
	}
	
	public Student(String stuNumber, String password) {
		this.stuNumber = stuNumber;
		this.password = password;
	}
	
	
	public Student(String stuNumber, String password, String dormBuildName,
			String dormName, String userName, String sex, String tel) {
		this.stuNumber = stuNumber;
		this.userName = userName;
		this.password = password;
		this.dormBuildName = dormBuildName;
		this.dormName = dormName;
		this.sex = sex;
		this.tel = tel;
	}

	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setDormBuildId(Integer dormBuildId) {
		this.dormBuildId = dormBuildId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		
	}
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}

	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}

	public String getDormBuildName() {
		return dormBuildName;
	}

	public void setDormBuildName(String dormBuildName) {
		this.dormBuildName = dormBuildName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getDormName() {
		return dormName;
	}

	public void setDormName(String dormName) {
		this.dormName = dormName;
	}


	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
