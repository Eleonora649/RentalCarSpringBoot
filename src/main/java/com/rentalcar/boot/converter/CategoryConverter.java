package com.rentalcar.boot.converter;

import java.util.List;

import com.rentalcar.boot.dto.CategoryDTO;
import com.rentalcar.boot.model.Category;

public interface CategoryConverter {

	Category convert(CategoryDTO catDto) throws Exception; 
	
	List<Category> convertAll(List<CategoryDTO> catDto) throws Exception;
	
	CategoryDTO reverseConvert(Category cat);
	
	List<CategoryDTO> reverseConvertAll(List<Category> cat);
}
