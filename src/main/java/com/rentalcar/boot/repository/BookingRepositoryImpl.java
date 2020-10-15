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
	public List<Booking> findBookingExist(Car car, User user, Date dateStart, Date dateEnd) {
		List<Booking> booking = entityManager
				.createQuery("SELECT b FROM Booking b WHERE ((car=:car OR user=:user) AND "
						+ "((b.startBooking<=:dateStart AND b.endOfBooking>=:dateStart) OR "
						+ "(b.endOfBooking<=:dateEnd AND b.startBooking>=:dateEnd)) AND (DATE(CURDATE())<=:dateEnd)) "
						+ "OR ((user=:user) AND (DATE(CURDATE())<=:dateEnd))", Booking.class)
				.setParameter("car", car)
				.setParameter("user", user)
				.setParameter("dateStart", dateStart)
				.setParameter("dateEnd", dateEnd)
				.getResultList();
		
		return booking;
	}
}
