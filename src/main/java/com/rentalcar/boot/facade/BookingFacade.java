package com.rentalcar.boot.facade;

import java.util.List;

import com.rentalcar.boot.dto.BookingDTO;

public interface BookingFacade {
	
	BookingDTO getBookingDtoById(Long id);
	
	List<BookingDTO> getAllBookings();
	
	BookingDTO createBooking(BookingDTO bookDto) throws Exception;
	
	BookingDTO updateBooking(Long id, BookingDTO bookDto) throws Exception;
	
	void deleteBookingDto(Long id);
}
