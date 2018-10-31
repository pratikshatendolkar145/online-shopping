package com.pra.shoppingbackend;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pra.dao.CategoryDao;
import com.pra.dao.ProductDao;
import com.pra.model.Category;
import com.pra.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Hello World..!!");
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	context.scan("com.pra");
    	context.refresh();
    	
      	ProductDao productDao=(ProductDao)context.getBean("productDAO");
    	Product product=new Product();
    	productDao.addProduct(product);
    	System.out.println("the product added successfully again....");

    	
   	
//    	CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDAO");
//    	System.out.println("hell1");
//    	Category category=new Category();
//    	System.out.println("hell2");

    	
//    	category.setCategoryName("books");
//    	category.setCategoryDesc("hjkgkukk");
    	
    	
    	/*categoryDao.addCategory(category);
    	System.out.println("the products added successfuly..");

    	category=categoryDao.getCategory(1);
		category.setCategoryDesc("All type of Mobile with Smart Feature");
		categoryDao.updateCategory(category);
		
		
		category=categoryDao.getCategory(4);
		categoryDao.deleteCategory(category);*/
		
		
        
    }
}
