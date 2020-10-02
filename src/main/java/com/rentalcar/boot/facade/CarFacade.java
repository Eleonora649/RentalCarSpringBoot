package com.rentalcar.boot.facade;

import java.util.List;

import com.rentalcar.boot.dto.CarDTO;

public interface CarFacade {

	List<CarDTO> getAllCars();
	
	CarDTO getCarDtoById(Long id);
	
	CarDTO createCar(CarDTO carDto);
	
	CarDTO updateCarDto(Long id, CarDTO carDto) throws Exception;
	
	void deleteCarDto(Long id);
}
