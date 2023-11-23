package com.raunak.bus.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name = "book_from", nullable = false, length = 20)
	private Integer bookFrom;
	
	@Column(name = "book_to", nullable = false, length = 20)
	private Integer bookTo;
	
	@Column(name = "number_of_passanger", nullable = false, length = 20)
	private Integer numberOfPassanger;
	
	@Column(name = "user", nullable = false, length = 20)
	private Integer user;
	
	@Column(name = "date", nullable = false, length = 20)
	private String date;
	
	@Column(name = "total_fare", nullable = false, length = 20)
	private Integer totalFare;
	
	@Column(name = "accepted", nullable = false, length = 20)
	private Boolean accepted;
	
	@Column(name = "distance", nullable = false, length = 20)
	private Integer distance;

	public Bookings(Integer id, Integer bookFrom, Integer bookTo, Integer numberOfPassanger, Integer user, String date,
			Integer totalFare, Boolean accepted, Integer distance) {
		this.id = id;
		this.bookFrom = bookFrom;
		this.bookTo = bookTo;
		this.numberOfPassanger = numberOfPassanger;
		this.user = user;
		this.date = date;
		this.totalFare = totalFare;
		this.accepted = accepted;
		this.distance = distance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookFrom() {
		return bookFrom;
	}

	public void setBookFrom(Integer bookFrom) {
		this.bookFrom = bookFrom;
	}

	public Integer getBookTo() {
		return bookTo;
	}

	public void setBookTo(Integer bookTo) {
		this.bookTo = bookTo;
	}

	public Integer getNumberOfPassanger() {
		return numberOfPassanger;
	}

	public void setNumberOfPassanger(Integer numberOfPassanger) {
		this.numberOfPassanger = numberOfPassanger;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	
	
}
