package com.rentalcar.boot.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.boot.dto.BookingDTO;
import com.rentalcar.boot.facade.BookingFacade;

@RestController
@RequestMapping(value="/bookings")
public class BookingController {
	
	@Autowired
	private BookingFacade bookingFacade;
	
	@GetMapping
	public List<BookingDTO> getAllBookings() {
		List<BookingDTO> bookings = bookingFacade.getAllBookings();
		return bookings;
	}
	
	@PostMapping
	public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookDto) {
		
		BookingDTO booking = null;
		try {
			booking = bookingFacade.createBooking(bookDto);
			if(booking!=null) {
				return new ResponseEntity<>(booking, HttpStatus.CREATED);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping
	public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDto) {
		try {
			Long id = bookingDto.getId();
			bookingFacade.updateBooking(id, bookingDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteBooking(@PathVariable Long id) {
		bookingFacade.deleteBookingDto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
