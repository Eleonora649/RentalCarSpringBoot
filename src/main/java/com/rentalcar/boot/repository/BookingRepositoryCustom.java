package com.rentalcar.boot.repository;

import java.util.Date;
import java.util.List;

import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;

public interface BookingRepositoryCustom {
	
	List<Booking> findBookingExist(Car car, Date dateStart);
	
}
