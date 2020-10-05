package com.rentalcar.boot.converter;

import java.text.ParseException;
import java.util.List;

import com.rentalcar.boot.dto.BookingDTO;
import com.rentalcar.boot.model.Booking;

public interface BookingConverter {

	Booking convert(BookingDTO bookingDto) throws ParseException;
	
	List<Booking> convertAll(List<BookingDTO> bookingDto) throws ParseException;
	
	BookingDTO reverseConvert(Booking booking);
	
	List<BookingDTO> reverseConvertAll(List<Booking> booking);
}
