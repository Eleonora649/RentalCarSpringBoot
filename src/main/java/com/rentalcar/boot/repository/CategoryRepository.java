package com.rentalcar.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentalcar.boot.model.Category;

@Repository("catRepository")
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public Category findByName(String name);
}
