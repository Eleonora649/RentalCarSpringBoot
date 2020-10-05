package com.rentalcar.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentalcar.boot.model.Booking;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
