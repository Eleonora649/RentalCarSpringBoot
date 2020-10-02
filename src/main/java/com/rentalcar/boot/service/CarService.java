package com.rentalcar.boot.service;

import java.util.List;

import com.rentalcar.boot.model.Car;

public interface CarService {

	List<Car> getAllCars(); 
	
	Car getCarById(Long id);
	
	Car createCar(Car car);
    
    Car updateCar(Car car);
    
    void deleteCar(Long id);
    
    
    
}
