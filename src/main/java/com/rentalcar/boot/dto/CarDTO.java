package com.rentalcar.boot.dto;

import com.rentalcar.boot.model.Car;

public class CarDTO {

	private Long idCar;
	private int yearOfRegistration;
	private String manufacturer;
	private String carModel;
	private String carLicensePlate;
	private Long category;
	
	public CarDTO() {
	}

	public CarDTO(Car car, Long cat) {
		this.category = cat;
		this.yearOfRegistration = car.getYearOfRegistration(); 
		this.manufacturer = car.getManufacturer();
		this.carLicensePlate = car.getCarLicensePlate();
		this.carModel = car.getCarModel();
	}
	
	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public int getYearOfRegistration() {
		return yearOfRegistration;
	}

	public void setYearOfRegistration(int yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}
	
	public Long getCategory() {
		return category;
	}
	
	public void setCategory(Long category) {
		this.category = category;
	}
}
