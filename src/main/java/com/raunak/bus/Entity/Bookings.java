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
	private Integer numberOfTickets;
	
	@Column(name = "user", nullable = false, length = 20)
	private Integer user;
	
	@Column(name = "date", nullable = false, length = 20)
	private String date;
	
	@Column(name = "distance", nullable = false, length = 20)
	private Integer distance;


	public Bookings(Integer id, Integer bookFrom, Integer bookTo, Integer numberOfTickets, Integer user, String date, Integer distance) {
		this.id = id;
		this.bookFrom = bookFrom;
		this.bookTo = bookTo;
		this.numberOfTickets = numberOfTickets;
		this.user = user;
		this.date = date;
		this.distance = distance;
	}

	public Bookings() {
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
		return numberOfTickets;
	}

	public void setNumberOfPassanger(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
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

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	
	
}
