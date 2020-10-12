package com.rentalcar.boot.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.User;

public class BookingRepositoryImpl implements BookingRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Booking> findBookingExist(Car car, Date dateStart, User user) {
		List<Booking> booking = entityManager
				.createQuery("SELECT b FROM Booking b WHERE (b.endOfBooking>=:dateStart and car=:idCar) or "
						+ "(b.endOfBooking>=:dateStart and user=:idUser)", Booking.class)
				.setParameter("idCar", car)
				.setParameter("dateStart", dateStart)
				.setParameter("idUser", user).getResultList();
		
		return booking;
	}
}
