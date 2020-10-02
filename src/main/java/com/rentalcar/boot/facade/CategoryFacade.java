package com.rentalcar.boot.facade;

import java.util.List;

import com.rentalcar.boot.dto.CategoryDTO;

public interface CategoryFacade {
	
	List<CategoryDTO> getAllCategory();
	
	CategoryDTO getCategoryDtoById(Long id);
	
	CategoryDTO createCategory(CategoryDTO catDto);
	
	CategoryDTO updateCategoryDto(Long id, CategoryDTO catDto);
	
	void deleteCategoryDto(Long id);
}
