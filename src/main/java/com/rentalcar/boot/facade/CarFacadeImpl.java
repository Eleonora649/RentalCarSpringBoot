package com.rentalcar.boot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentalcar.boot.converter.CarConverter;
import com.rentalcar.boot.converter.CategoryConverter;
import com.rentalcar.boot.dto.CarDTO;
import com.rentalcar.boot.dto.CategoryDTO;
import com.rentalcar.boot.model.Car;
import com.rentalcar.boot.model.Category;
import com.rentalcar.boot.service.CarService;
import com.rentalcar.boot.service.CategoryService;

@Component("carFacade")
public class CarFacadeImpl implements CarFacade {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CarConverter carConverter;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public List<CarDTO> getAllCars() {
		List<Car> car = carService.getAllCars();
		return carConverter.reverseConvertAll(car);
	}

	@Override
	public CarDTO getCarDtoById(Long id) {
		Car car = carService.getCarById(id);
		CarDTO carDto = carConverter.reverseConvert(car);
		return carDto;
	}

	@Override
	public CarDTO createCar(CarDTO carDto) {
		Car car = carConverter.convert(carDto);
		carService.createCar(car);
		return carConverter.reverseConvert(car);
	}

	@Override
	public CarDTO updateCarDto(Long id, CarDTO carDto) throws Exception {
		Car car = carConverter.convert(carDto);

		if(car!=null) {
			car = carService.updateCar(car);
			carDto = carConverter.reverseConvert(car);
		}
		return carDto;
	}

	@Override
	public void deleteCarDto(Long id) {
		carService.deleteCar(id);
	}

}
