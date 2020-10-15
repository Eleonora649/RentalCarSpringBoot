package com.rentalcar.boot.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentalcar.boot.dto.BookingDTO;
import com.rentalcar.boot.model.Booking;

@Component("bookingConverter")
public class BookingConverterImpl implements BookingConverter {

	@Autowired
	private CarConverter carConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public Booking convert(BookingDTO bookingDto) throws Exception {
		Booking booking = new Booking();
		Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(bookingDto.getStartBooking());
		Date dateEnd = new SimpleDateFormat("yyy-MM-dd").parse(bookingDto.getEndOfBooking());
		
		booking.setStartBooking(dateStart);
		booking.setEndOfBooking(dateEnd);
		booking.setCar(carConverter.convert(bookingDto.getCar()));
		booking.setUser(userConverter.convert(bookingDto.getUser()));
		
		return booking;
	}

	@Override
	public List<Booking> convertAll(List<BookingDTO> bookingDto) throws Exception {
		List<Booking> bookings = new ArrayList<Booking>();
		Iterator<BookingDTO> bookDto = bookingDto.iterator();
		
		while(bookDto.hasNext()) {
			BookingDTO result = bookDto.next();
			bookings.add(this.convert(result));
		}
		return bookings;
	}

	@Override
	public BookingDTO reverseConvert(Booking booking) {
		BookingDTO bookDto = new BookingDTO();
		String dateStart = new SimpleDateFormat("yyyy-MM-dd").format(booking.getStartBooking());
		String dateEnd = new SimpleDateFormat("yyyy-MM-dd").format(booking.getEndOfBooking());
		
		bookDto.setStartBooking(dateStart);
		bookDto.setEndOfBooking(dateEnd);
		bookDto.setCar(carConverter.reverseConvert(booking.getCar()));
		bookDto.setUser(userConverter.reverseConvert(booking.getUser()));
		
		return bookDto;
	}

	@Override
	public List<BookingDTO> reverseConvertAll(List<Booking> bookings) {
		List<BookingDTO> bookingDto = new ArrayList<>();
		Iterator<Booking> booking = bookings.iterator();
		
		while(booking.hasNext()) {
			Booking result = booking.next();
			bookingDto.add(this.reverseConvert(result));
		}
		return bookingDto;
	}

}
