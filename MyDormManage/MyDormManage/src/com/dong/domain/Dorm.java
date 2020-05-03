package com.dong.domain;

public class Dorm {
	private Integer dormId;
	private Double electric;
	private String hygiene;
	private String dormName;
	
	
	@Override
	public String toString() {
		return "Dorm [dormId=" + dormId + ", electric=" + electric + ", hygiene=" + hygiene + ", dormName=" + dormName
				+ "]";
	}
	public Integer getDormId() {
		return dormId;
	}
	public void setDormId(Integer dormId) {
		this.dormId = dormId;
	}
	public Double getElectric() {
		return electric;
	}
	public void setElectric(Double electric) {
		this.electric = electric;
	}
	public String getHygiene() {
		return hygiene;
	}
	public void setHygiene(String hygiene) {
		this.hygiene = hygiene;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	
	
}
