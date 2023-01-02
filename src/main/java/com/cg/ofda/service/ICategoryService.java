package com.cg.ofda.service;

import java.util.List;

import com.cg.ofda.dto.CategoryDto;
import com.cg.ofda.exception.CategoryException;


public interface ICategoryService {
	public CategoryDto addCategory(CategoryDto cat) throws CategoryException;
	public CategoryDto updateCategory(CategoryDto cat);
	public CategoryDto removeCategory(String catId)throws CategoryException;
	public CategoryDto viewCategory(String catId) throws CategoryException;
	public List<CategoryDto> viewAllCategory() throws CategoryException;

}
