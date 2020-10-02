package com.rentalcar.boot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentalcar.boot.converter.CategoryConverter;
import com.rentalcar.boot.dto.CategoryDTO;
import com.rentalcar.boot.model.Category;
import com.rentalcar.boot.service.CategoryService;

@Component("categoryFacade")
public class CategoryFacadeImpl implements CategoryFacade {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> cat = categoryService.listCategories();
		return categoryConverter.reverseConvertAll(cat);
	}

	@Override
	public CategoryDTO getCategoryDtoById(Long id) {
		Category cat = categoryService.getCategoryById(id);
		CategoryDTO catDto = categoryConverter.reverseConvert(cat);
		return catDto;
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO catDto) {
		Category cat = categoryConverter.convert(catDto);
		categoryService.addCategory(cat);
		return categoryConverter.reverseConvert(cat);
	}

	@Override
	public CategoryDTO updateCategoryDto(Long id, CategoryDTO catDto) {
		Category cat = categoryConverter.convert(catDto);
		
		if(cat!=null) {
			cat = categoryService.updateCategory(cat);
			catDto = categoryConverter.reverseConvert(cat);
		}
		return catDto;
	}

	@Override
	public void deleteCategoryDto(Long id) {
		categoryService.deleteCategory(id);
	}
	
}
