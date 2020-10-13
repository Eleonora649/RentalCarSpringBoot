package com.rentalcar.boot.service;

import java.util.List;

import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.Category;

public interface CarService {

	List<Car> getAllCars(); 
	
	Car getCarById(Long id);
	
	List<Car> getCarByCategory(Long id);
	
	Car createCar(Car car);
    
    Car updateCar(Long id, String model, String manufacturer, String license, int year, Category category);
    
    void deleteCar(Long id);

}