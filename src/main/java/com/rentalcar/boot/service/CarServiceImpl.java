package com.rentalcar.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.Category;
import com.rentalcar.boot.repository.CarRepository;

@Service("carService")
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<Car> getAllCars() {
		return (List<Car>) carRepository.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.getOne(id);
	}

	@Override
	public Car createCar(Car car) {
		return car = carRepository.save(car);
	}

	@Override
	public Car updateCar(Long id, String model, String manufacturer, String license, int year, Category category) {
		Car c = this.getCarById(id);
		
		if(c!=null) {
			c.setCarModel(model);
			c.setManufacturer(manufacturer);
			c.setCarLicensePlate(license);
			c.setYearOfRegistration(year);
			c.setCategory(category);
		}
		return carRepository.save(c);
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}

}
