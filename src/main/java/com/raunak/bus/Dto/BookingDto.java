package com.raunak.bus.Dto;

import java.util.List;

public class BookingDto {
	
    private Integer id;

    private Integer destination;

    private Integer from;

    private Integer numberOfTickets;

    private Integer user;
    
	private String journeyDate;

    private Integer distance;
    
    private List<PassangerDto> tickets;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDestination() {
		return destination;
	}

	public void setDestination(Integer destination) {
		this.destination = destination;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public List<PassangerDto> getTickets() {
		return tickets;
	}

	public void setTickets(List<PassangerDto> tickets) {
		this.tickets = tickets;
	}
    
    
}



