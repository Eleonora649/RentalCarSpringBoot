package com.rentalcar.boot.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentalcar.boot.dto.BookingDTO;
import com.rentalcar.boot.model.Booking;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.User;
import com.rentalcar.boot.service.CarService;
import com.rentalcar.boot.service.UserService;

@Component("bookingConverter")
public class BookingConverterImpl implements BookingConverter {

	@Autowired
	private CarService carService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Booking convert(BookingDTO bookingDto) throws ParseException {
		Booking booking = new Booking();
		Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(bookingDto.getStartBooking());
		Date dateEnd = new SimpleDateFormat("yyy-MM-dd").parse(bookingDto.getEndOfBooking());
		Car car = carService.getCarById(bookingDto.getCar());
		User user = userService.getUserById(bookingDto.getUser());
		
		booking.setStartBooking(dateStart);
		booking.setEndOfBooking(dateEnd);
		booking.setCar(car);
		booking.setUser(user);
		
		return booking;
	}

	@Override
	public List<Booking> convertAll(List<BookingDTO> bookingDto) throws ParseException {
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
		Long carId = booking.getCar().getIdCar();
		Long userId = booking.getUser().getIdUser();
		
		bookDto.setStartBooking(dateStart);
		bookDto.setEndOfBooking(dateEnd);
		bookDto.setCar(carId);
		bookDto.setUser(userId);
		
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
