package com.rentalcar.boot.converter;

import java.util.List;

import com.rentalcar.boot.dto.CategoryDTO;
import com.rentalcar.boot.model.Category;

public interface CategoryConverter {

	Category convert(CategoryDTO catDto); 
	
	List<Category> convertAll(List<CategoryDTO> catDto);
	
	CategoryDTO reverseConvert(Category cat);
	
	List<CategoryDTO> reverseConvertAll(List<Category> cat);
}
