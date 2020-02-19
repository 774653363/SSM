package ek.zhou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ek.zhou.pojo.Category;
import ek.zhou.service.CategoryService;
import ek.zhou.util.Page;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page,Category category){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStartIndex(), page.getPageSize());
		List<Category> cs = categoryService.list(category.getName());
		PageInfo<Category> pageInfo = new PageInfo<>(cs);
		int total = (int) pageInfo.getTotal();
		page.caculate(total);
		//放入转发参数
		mav.addObject("cs", cs);
		//设置jsp路径
		mav.setViewName("listCategory");
		System.out.println(page);
		return mav;
	}
	@RequestMapping("addCategoryUI")
	public ModelAndView addtCategoryUI(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addCategory");
		return mav;
	}
	
	@RequestMapping("addCategory")
	public ModelAndView addtCategory(Category category){
		ModelAndView mav = new ModelAndView();
		categoryService.add(category);
		mav.setViewName("redirect:listCategory");
		return mav;
	}
	@RequestMapping("editCategory")
	public ModelAndView editCategory(Category category){
		ModelAndView mav = new ModelAndView();
		category = categoryService.get(category);
		mav.addObject("category",category);
		mav.setViewName("editCategory");
		return mav;
	}
	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(Category category){
		ModelAndView mav = new ModelAndView();
		categoryService.delete(category);
		mav.setViewName("redirect:listCategory");
		return mav;
	}
	@RequestMapping("updateCategory")
	public ModelAndView updateCategory(Category category){
		ModelAndView mav = new ModelAndView();
		categoryService.update(category);
		mav.setViewName("redirect:listCategory");
		return mav;
	}
	
}
