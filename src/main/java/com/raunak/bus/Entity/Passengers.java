package com.raunak.bus.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passengers")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    
    private Integer bookingId;
    
    private String journeyDate;

    private String passangerName;

    private Integer passangerAge;
    
    private String gender;

    private Integer fare;
    
    private Boolean journeyType;

    private Boolean status;
    
    private Integer daysToDelete;
    
    private Integer bookedByUser;
    
	public Passengers() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public Integer getPassangerAge() {
		return passangerAge;
	}

	public void setPassangerAge(Integer passangerAge) {
		this.passangerAge = passangerAge;
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


	public Boolean getJourneyType() {
		return journeyType;
	}


	public void setJourneyType(Boolean journeyType) {
		this.journeyType = journeyType;
	}


	public String getJourneyDate() {
		return journeyDate;
	}


	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Integer getDaysToDelete() {
		return daysToDelete;
	}


	public void setDaysToDelete(Integer daysToDelete) {
		this.daysToDelete = daysToDelete;
	}


	public Integer getBookedByUser() {
		return bookedByUser;
	}


	public void setBookedByUser(Integer bookedByUser) {
		this.bookedByUser = bookedByUser;
	}
	
}
