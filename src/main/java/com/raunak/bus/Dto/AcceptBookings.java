package com.raunak.bus.Dto;

import java.util.List;

public class AcceptBookings {
	private List<Integer> passangerIds;
	private String date;
	public List<Integer> getPassangerIds() {
		return passangerIds;
	}
	public void setPassangerIds(List<Integer> passangerIds) {
		this.passangerIds = passangerIds;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
