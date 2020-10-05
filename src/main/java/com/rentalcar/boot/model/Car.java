package com.rentalcar.boot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rentalcar.boot.dto.CarDTO;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_car")
	private Long idCar;

	@Column(name="registration_year")
	private int yearOfRegistration;

	@Column(name="manufacturer")
	private String manufacturer;

	@Column(name="car_model")
	private String carModel;

	@Column(name="car_license_plate")
	private String carLicensePlate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_category")
	private Category category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="car")
	private List<Booking> booking;

	public Car() {
		super();
	}
	
	public Car(CarDTO carDto, Category cat) {
		this.category = cat;
		this.yearOfRegistration = carDto.getYearOfRegistration(); 
		this.manufacturer = carDto.getManufacturer();
		this.carLicensePlate = carDto.getCarLicensePlate();
		this.carModel = carDto.getCarModel();
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

}


