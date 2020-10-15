package com.rentalcar.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.Booking;
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
	public Booking createBooking(Booking booking1) {
		Booking booking = null;

		if(booking1.getStartBooking()!=null && booking1.getEndOfBooking()!=null) {
			List<Booking> exist = bookingRepository.findBookingExist(booking1.getCar(), booking1.getUser(), booking1.getStartBooking(), booking1.getEndOfBooking());
			
			if(exist.isEmpty()) {
				booking = new Booking(booking1.getStartBooking(), booking1.getEndOfBooking(), booking1.getUser(), booking1.getCar());
				bookingRepository.save(booking);
				System.out.println("Prenotazione registrata con successo");
			}
			else {
				System.out.println("Prenotazione non valida");
			}
		} 
		return booking;
	}
		
	@Override
	public Booking updateBooking(Long id, Booking booking) {
		Booking b = this.getBookingById(id);
		
		if(b!=null) {
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
