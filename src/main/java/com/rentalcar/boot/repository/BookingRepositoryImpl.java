package com.rentalcar.boot.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;

public class BookingRepositoryImpl implements BookingRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Booking> findBookingExist(Car car, Date dateStart) {
		List<Booking> booking = entityManager.createQuery("SELECT b FROM Booking b WHERE b.endOfBooking>=:dateStart and id_car=:idCar", Booking.class)
				.setParameter("idCar", car).setParameter("dateStart", dateStart).getResultList();
		
		return booking;
	}

}
