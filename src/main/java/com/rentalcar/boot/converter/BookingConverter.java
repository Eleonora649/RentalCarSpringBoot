package com.rentalcar.boot.converter;

import java.util.List;

import com.rentalcar.boot.dto.BookingDTO;
import com.rentalcar.boot.model.Booking;

public interface BookingConverter {

	Booking convert(BookingDTO bookingDto) throws Exception;
	
	List<Booking> convertAll(List<BookingDTO> bookingDto) throws Exception;
	
	BookingDTO reverseConvert(Booking booking);
	
	List<BookingDTO> reverseConvertAll(List<Booking> booking);
}
