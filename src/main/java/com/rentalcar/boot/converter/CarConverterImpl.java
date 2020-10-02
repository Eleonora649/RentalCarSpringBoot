package com.rentalcar.boot.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentalcar.boot.dto.CarDTO;
import com.rentalcar.boot.dto.CategoryDTO;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.Category;
import com.rentalcar.boot.service.CategoryService;

@Component("carConverter")
public class CarConverterImpl implements CarConverter{

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public Car convert(CarDTO carDto) {
		
		Category cat = categoryService.getCategoryById(carDto.getCategory());
		Car car = new Car(carDto, cat);
		
		return car;
	}

	@Override
	public List<Car> convertAll(List<CarDTO> carDto) throws Exception {
		List<Car> cars = new ArrayList<Car>();
		Iterator<CarDTO> carDtos = carDto.iterator();
		
		while(carDtos.hasNext()) {
			CarDTO result = carDtos.next();
			cars.add(this.convert(result));
		}
		return cars;
	}

	@Override
	public CarDTO reverseConvert(Car car) {
		Category cat = categoryService.getCategoryById(car.getCategory().getIdCategory());
		CategoryDTO catDto = categoryConverter.reverseConvert(cat);
		
		CarDTO carDto = new CarDTO();
		
		carDto.setCarModel(car.getCarModel());
		carDto.setManufacturer(car.getManufacturer());
		carDto.setCarLicensePlate(car.getCarLicensePlate());
		carDto.setYearOfRegistration(car.getYearOfRegistration());
		carDto.setCategory(catDto.getIdCategory());
		
		return carDto;
	}

	@Override
	public List<CarDTO> reverseConvertAll(List<Car> cars) {
		List<CarDTO> carDtos = new ArrayList<>();
		Iterator<Car> car = cars.iterator();
		
		while(car.hasNext()) {
			Car result = car.next();
			carDtos.add(this.reverseConvert(result));
		}
		return carDtos;
	}

}
