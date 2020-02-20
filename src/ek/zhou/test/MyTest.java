package ek.zhou.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ek.zhou.pojo.Category;
import ek.zhou.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
	@Autowired
    private CategoryService categoryService;
 
    @Test
    public void testAddTwo() {
        categoryService.deleteAll();
        categoryService.addTwo();
         
    }
    @Test
    public void testAdd() {
    	for(int i=0;i<100;i++){
    		Category category = new Category();
    		category.setName("category "+i);
    		categoryService.add(category);
    	}
         
    }
}
