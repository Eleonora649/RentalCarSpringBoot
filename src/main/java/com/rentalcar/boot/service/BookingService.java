package com.rentalcar.boot.service;

import java.util.Date;
import java.util.List;

import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.User;

public interface BookingService {
	
	List<Booking> getAllBookings();
	
	Booking getBookingById(Long id);
	
	Booking createBooking(Date startBooking, Date endBooking, User user, Car car);
	
	Booking updateBooking(Long id, Date startBooking, Date endBooking, User user, Car car);
	
	void deleteBooking(Long id);

}
