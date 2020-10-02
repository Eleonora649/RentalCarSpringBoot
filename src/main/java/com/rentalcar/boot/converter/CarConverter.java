package com.rentalcar.boot.converter;

import java.util.List;

import com.rentalcar.boot.dto.CarDTO;
import com.rentalcar.boot.model.Car;

public interface CarConverter {
	
	Car convert(CarDTO carDto);
	
	List<Car> convertAll(List<CarDTO> carDto) throws Exception;
	
	CarDTO reverseConvert(Car car);
	
	List<CarDTO> reverseConvertAll(List<Car> car);
}
