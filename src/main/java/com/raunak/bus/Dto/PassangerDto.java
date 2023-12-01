package com.raunak.bus.Dto;

public class PassangerDto {
	private String name;
	private Integer age;
	private String gender;
	private Integer fare;
	
	public PassangerDto(String name, Integer age, String gender, Integer fare) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fare = fare;
	}
	public PassangerDto() {

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getFare() {
		return fare;
	}
	public void setFare(Integer fare) {
		this.fare = fare;
	}
}