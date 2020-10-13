package com.rentalcar.boot.service;

import java.util.List;

import com.rentalcar.boot.model.Category;

public interface CategoryService {

	List<Category> listCategories();
	
	Category getCategoryById(Long id);
	
	void addCategory(Category category);

	Category updateCategory(Category cat);

	void deleteCategory(Long id);
}