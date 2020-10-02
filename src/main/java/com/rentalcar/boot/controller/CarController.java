package com.rentalcar.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.boot.dto.CarDTO;
import com.rentalcar.boot.dto.CategoryDTO;
import com.rentalcar.boot.facade.CarFacade;
import com.rentalcar.boot.facade.CategoryFacade;

@RestController
@RequestMapping(value="/cars")
public class CarController {

	@Autowired
	private CarFacade carFacade;
	
	@Autowired
	private CategoryFacade catFacade;
	
	@GetMapping
	public List<CarDTO> getAllCars() {
		return carFacade.getAllCars();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarDTO> getCarById(@PathVariable(value="id") Long id) {
		CarDTO car = carFacade.getCarDtoById(id);
		return new ResponseEntity<>(car, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDto) {
		CarDTO car = null;
		try {
			car = carFacade.createCar(carDto);
			return new ResponseEntity<>(car, HttpStatus.CREATED);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDto, CategoryDTO catDto) {
		try {
			Long id = carDto.getIdCar();
			List<CategoryDTO> listCategory = catFacade.getAllCategory();
			carFacade.updateCarDto(id, carDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id) {
		carFacade.deleteCarDto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
