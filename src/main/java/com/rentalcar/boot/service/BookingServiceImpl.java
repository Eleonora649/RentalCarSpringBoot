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
			List<Booking> exist = bookingRepository.findBookingExist(car, startBooking, user);
			
			if(exist.isEmpty()) {
				booking = new Booking(startBooking, endBooking, user, car);
				bookingRepository.save(booking);
				System.out.println("Prenotazione registrata con successo");
			}
			for (Booking b : exist) {
				Car c = b.getCar();
				User u = b.getUser();
				Date start = b.getStartBooking();
				Date end = b.getEndOfBooking();
			
				if((c!=null && c==car) && (end!=null && start!=null)) {
					System.out.println("la macchina: " + c.getCarModel() + " è già noleggiata in quei giorni");
				} 
				else if(u!=null) {
					System.out.println("l'utente: "+ u.getName() + " ha già attiva un altra prenotazione");
				}
			}
		} return booking;
	}

	@Override
	public Booking updateBooking(Long id, Date startBooking, Date endBooking, User user, Car car) {
		Booking b = this.getBookingById(id);
		
		if(b!=null) {
			b.setStartBooking(startBooking);
			b.setEndOfBooking(endBooking);
			b.setCar(car);
			b.setUser(user);
		}
		return bookingRepository.save(b);
	}

	@Override
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}

}
