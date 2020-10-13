package com.rentalcar.boot.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentalcar.boot.converter.BookingConverter;
import com.rentalcar.boot.dto.BookingDTO;
import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.User;
import com.rentalcar.boot.service.BookingService;

@Component("bookingFacade")
public class BookingFacadeImpl implements BookingFacade {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingConverter bookingConverter;
	
	@Override
	public BookingDTO getBookingDtoById(Long id) {
		Booking booking = bookingService.getBookingById(id);
		BookingDTO bookDto = bookingConverter.reverseConvert(booking);
		return bookDto;
	}

	@Override
	public List<BookingDTO> getAllBookings() {
		List<Booking> booking = bookingService.getAllBookings();
		List<BookingDTO> bookingDto = bookingConverter.reverseConvertAll(booking);
		return bookingDto;
	}

	@Override
	public BookingDTO createBooking(BookingDTO bookDto) throws Exception {
		Booking booking = bookingConverter.convert(bookDto);
		
		Date dateStart = booking.getStartBooking();
		Date dateEnd = booking.getEndOfBooking();
		User user = booking.getUser();
		Car car = booking.getCar();

		Booking b = bookingService.createBooking(dateStart, dateEnd, user, car);
		BookingDTO bookingDto = null;

		if(b!=null) {
			bookingDto = bookingConverter.reverseConvert(b);
		}
		return bookingDto;
	}

	@Override
	public BookingDTO updateBooking(Long id, BookingDTO bookDto) throws Exception {
		Booking booking = bookingConverter.convert(bookDto);
		
		Date dateStart = booking.getStartBooking();
		Date dateEnd = booking.getEndOfBooking();
		User user = booking.getUser();
		Car car = booking.getCar();
		
		if(booking!=null) {
			booking = bookingService.updateBooking(id, dateStart,dateEnd, user, car);
			bookDto = bookingConverter.reverseConvert(booking);
		}
		return bookDto;
	}

	@Override
	public void deleteBookingDto(Long id) {
		bookingService.deleteBooking(id);
	}

}
