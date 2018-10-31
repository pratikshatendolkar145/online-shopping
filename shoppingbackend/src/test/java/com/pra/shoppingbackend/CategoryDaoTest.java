package com.pra.shoppingbackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pra.dao.CategoryDao;
import com.pra.model.Category;

public class CategoryDaoTest
{
	 private static AnnotationConfigApplicationContext context;
     private static CategoryDao categoryDao;
	 private static Category category;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.pra");
		context.refresh();
		categoryDao=(CategoryDao)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		 category=new Category();
		category.setCategoryName("Moblie");
		category.setCategoryDesc("All the Category Mobile");
		assertEquals("Adding Category Successfully..:",true,categoryDao.addCategory(category));
	}
	/*@Ignore
	@Test
	/public void updateCategoryTest()
	{
		 category=  categoryDao.getCategory(1);
		category.setCategoryName("laptop");
		category.setCategoryDesc("All the Lenevo laptop with Smart Feature");
		assertTrue("updation successfull.....!!",categoryDao.updateCategory(category));
	}
	/*@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDao.getCategory(4);
		assertTrue("Problem in deleting the Category",categoryDao.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDao.listCategories();
		assertNotNull("Problem in Listing Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}
	}
*/
}

