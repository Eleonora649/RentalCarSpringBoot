package com.rentalcar.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.repository.CarRepository;

@Service("carService")
public class CarServiceDB implements CarService {

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
	public Car updateCar(Car car) {
		Car c = this.getCarById(car.getIdCar());
		
		if(car!=null && c!=null) {
			c.setCarModel(car.getCarModel());
			c.setManufacturer(car.getManufacturer());
			c.setCarLicensePlate(car.getCarLicensePlate());
			c.setYearOfRegistration(car.getYearOfRegistration());
			c.setCategory(car.getCategory());
		}
		return carRepository.save(c);
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}

}
