package com.raunak.bus.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "passengers")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    
    @NotBlank(message = "bookingId is required")
    private Integer bookingId;
    
    @NotBlank(message = "passanger Name is required")
    private String passangerName;

    @NotBlank(message = "passanger age is required")
    private Integer passangerAge;
    
    @NotBlank(message = "Gender is required")
    private String gender;

	public Passengers(Integer id, @NotBlank(message = "bookingId is required") Integer bookingId,
			@NotBlank(message = "passanger Name is required") String passangerName,
			@NotBlank(message = "passanger age is required") Integer passangerAge,
			@NotBlank(message = "Gender is required") String gender) {
		this.id = id;
		this.bookingId = bookingId;
		this.passangerName = passangerName;
		this.passangerAge = passangerAge;
		this.gender = gender;
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
    
    
}
