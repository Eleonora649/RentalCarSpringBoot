package com.rentalcar.boot.facade;

import java.text.ParseException;
import java.util.List;

import com.rentalcar.boot.dto.BookingDTO;

public interface BookingFacade {
	
	BookingDTO getBookingDtoById(Long id);
	
	List<BookingDTO> getAllBookings();
	
	BookingDTO createBooking(BookingDTO bookDto) throws ParseException;
	
	BookingDTO updateBooking(Long id, BookingDTO bookDto) throws ParseException;
	
	void deleteBookingDto(Long id);
}
