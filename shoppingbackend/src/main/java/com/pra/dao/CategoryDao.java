package com.pra.dao;

import java.util.List;
import com.pra.model.Category;

public interface CategoryDao 
{
	void addCategory(Category category);//C
	void updateCategory(Category category);//U
	Category getCategory(int id);//R
	void deleteCategory(int id);//D
	List<Category> getAllCategory();//
}
