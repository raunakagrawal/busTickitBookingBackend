package com.raunak.bus.Dto;

public class AdminPassangerDto {
	
	private String date;
	private String fromCity;
	private String toCity;
	private Integer passangerId;
	private Integer passangerAge;
	private Integer passangerUser;
	private String passangerName;
	private String passangerGender;
	private Integer fare;
	private Boolean journeyType;
	private Boolean status;
	
	public AdminPassangerDto() {
		
	}

	public AdminPassangerDto(String date, String fromCity, String toCity, Integer passangerId, Integer passangerAge,
			Integer passangerUser, String passangerName, String passangerGender, Integer fare, Boolean journeyType,
			Boolean status) {
		
		this.date = date;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.passangerId = passangerId;
		this.passangerAge = passangerAge;
		this.passangerUser = passangerUser;
		this.passangerName = passangerName;
		this.passangerGender = passangerGender;
		this.fare = fare;
		this.journeyType = journeyType;
		this.status = status;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public Integer getPassangerId() {
		return passangerId;
	}
	public void setPassangerId(Integer passangerId) {
		this.passangerId = passangerId;
	}
	public Integer getPassangerAge() {
		return passangerAge;
	}
	public void setPassangerAge(Integer passangerAge) {
		this.passangerAge = passangerAge;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	public Integer getFare() {
		return fare;
	}
	public void setFare(Integer fare) {
		this.fare = fare;
	}
	public Boolean getJourneyType() {
		return journeyType;
	}
	public void setJourneyType(Boolean journeyType) {
		this.journeyType = journeyType;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getPassangerGender() {
		return passangerGender;
	}
	public void setPassangerGender(String passangerGender) {
		this.passangerGender = passangerGender;
	}
	public Integer getPassangerUser() {
		return passangerUser;
	}
	public void setPassangerUser(Integer passangerUser) {
		this.passangerUser = passangerUser;
	}
	
	
	
}
