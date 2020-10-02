package com.rentalcar.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.Category;
import com.rentalcar.boot.repository.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository catRepository;
	
	@Override
	public List<Category> listCategories() {
		return catRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		return catRepository.getOne(id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return catRepository.findByName(name);
	}

	@Override
	public void addCategory(Category category) {
		catRepository.save(category);
	}
	
	@Override
	public Category updateCategory(Category cat) {
		Category c = this.getCategoryById(cat.getIdCategory());
		
		if(cat!=null && c!=null) {
			c.setIdCategory(cat.getIdCategory());
			c.setName(cat.getName());
		}
		return catRepository.save(c);
	}

	@Override
	public void deleteCategory(Long id) {
		catRepository.deleteById(id);
	}
}
