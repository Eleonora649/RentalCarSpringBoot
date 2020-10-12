package com.rentalcar.boot.repository;

import java.util.Date;
import java.util.List;

import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.User;

public interface BookingRepositoryCustom {
	
	List<Booking> findBookingExist(Car car, Date dateStart, User user);

}