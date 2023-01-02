package com.cg.ofda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofda.dto.CategoryDto;
import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.service.ICategoryServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	ICategoryServiceImpl categoryService;
	
	
	@PostMapping("/addcategory")
	public CategoryDto addCategory(@Valid @RequestBody CategoryDto cat) {
		return categoryService.addCategory(cat);
	}
	
	@PutMapping("/updatecategory")
	public CategoryDto updateCategory(@Valid @RequestBody CategoryDto cat) {
		return categoryService.updateCategory(cat);
	}
	
	@DeleteMapping("/removecategory/{id}")
	public CategoryDto removeCategory(@PathVariable("id") String id) throws CategoryException {
		return categoryService.removeCategory(id);
	}
	
	@GetMapping("/viewallcategory")
	public List<CategoryDto> viewAllCategory() throws CategoryException{
		return categoryService.viewAllCategory();
	}
	
	@GetMapping("/viewcategory/{id}")
	public CategoryDto viewcategory(@PathVariable("id") String id) throws CategoryException {
		return categoryService.viewCategory(id);
	}
}