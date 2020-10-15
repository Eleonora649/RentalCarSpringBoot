package com.rentalcar.boot.service;

import java.util.List;

import com.rentalcar.boot.model.Booking;

public interface BookingService {
	
	List<Booking> getAllBookings();
	
	Booking getBookingById(Long id);
	
	Booking createBooking(Booking booking);
	
	Booking updateBooking(Long id, Booking booking);
	
	void deleteBooking(Long id);

}
