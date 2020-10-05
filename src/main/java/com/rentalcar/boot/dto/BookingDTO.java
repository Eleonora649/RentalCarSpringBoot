package com.rentalcar.boot.dto;

public class BookingDTO {
	
	private Long id;
	private String startBooking;
	private String endOfBooking;
	private Long user;
	private Long car;
	
	public BookingDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStartBooking() {
		return startBooking;
	}
	
	public void setStartBooking(String startBooking) {
		this.startBooking = startBooking;
	}
	
	public String getEndOfBooking() {
		return endOfBooking;
	}
	
	public void setEndOfBooking(String endOfBooking) {
		this.endOfBooking = endOfBooking;
	}
	
	public Long getUser() {
		return user;
	}
	
	public void setUser(Long user) {
		this.user = user;
	}
	
	public Long getCar() {
		return car;
	}
	
	public void setCar(Long car) {
		this.car = car;
	}
	
}
