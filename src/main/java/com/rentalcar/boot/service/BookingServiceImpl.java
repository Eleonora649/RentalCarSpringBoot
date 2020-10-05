package com.rentalcar.boot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.User;
import com.rentalcar.boot.repository.BookingRepository;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<Booking> getAllBookings() {
		List<Booking> booking = bookingRepository.findAll();
		return booking;
	}

	@Override
	public Booking getBookingById(Long id) {
		return bookingRepository.getOne(id);
	}

	@Override
	public Booking createBooking(Date startBooking, Date endBooking, User user, Car car) {
		Booking booking = null;
		
		if(startBooking!=null && endBooking!=null) {
			booking = new Booking(startBooking, endBooking, user, car);
			bookingRepository.save(booking);
		}
		return booking;
	}

	@Override
	public Booking updateBooking(Booking booking) {
		Booking b = this.getBookingById(booking.getIdBooking());
		
		if(booking!=null && b!=null) {
			b.setStartBooking(booking.getStartBooking());
			b.setEndOfBooking(booking.getEndOfBooking());
			b.setCar(booking.getCar());
			b.setUser(booking.getUser());
		}
		return bookingRepository.save(b);
	}

	@Override
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}

}
