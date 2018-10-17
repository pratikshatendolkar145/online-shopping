package com.pra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	private String categoryname;
	private String categorydesc;
	
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	public String getCategoryname() 
	{
		return categoryname;
	}
	public void setCategoryname(String categoryname) 
	{
		this.categoryname = categoryname;
	}
	public String getCategorydesc() 
	{
		return categorydesc;
	}
	public void setCategorydesc(String categorydesc) 
	{
		this.categorydesc = categorydesc;
	}
	
	
	

}
