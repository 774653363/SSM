package ek.zhou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ek.zhou.pojo.Category;
import ek.zhou.pojo.Product;
import ek.zhou.service.CategoryService;
import ek.zhou.service.ProductService;
import ek.zhou.util.Page;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("listProductByCid")
	public ModelAndView listProductByCid(Page page,Product product){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStartIndex(), page.getPageSize());
		List<Product> ps = productService.listByCid(product);
		PageInfo<Product> pageInfo = new PageInfo<>(ps);
		page.caculate((int)pageInfo.getTotal());
		mav.addObject("ps", ps);
		Category category = categoryService.get(product.getCategory().getId());
		mav.addObject("category", category);
		mav.setViewName("listProduct");
		return mav;
	}
	@RequestMapping("addProductUI")
	public ModelAndView addProductUI(Product product){
		ModelAndView mav = new ModelAndView("addProduct");
		return mav;
	}
	@RequestMapping("addProduct")
	public ModelAndView addProduct(Product product){
		ModelAndView mav = new ModelAndView("redirect:listProductByCid?category.id="+product.getCategory().getId());
		productService.add(product);
		return mav;
	}
	@RequestMapping("editProduct")
	public ModelAndView editProduct(Product product){
		ModelAndView mav = new ModelAndView("editProduct");
		Product p = productService.get(product.getId());
		mav.addObject("product",p);
		return mav;
	}
	@RequestMapping("updateProduct")
	public ModelAndView updateProduct(Product product){
		ModelAndView mav = new ModelAndView("redirect:listProductByCid?category.id="+product.getCategory().getId());
		productService.update(product);
		return mav;
	}
	@RequestMapping("deleteProduct")
	public ModelAndView deleteProduct(Product product){
		ModelAndView mav = new ModelAndView("redirect:listProductByCid?category.id="+product.getCategory().getId());
		productService.delete(product.getId());
		return mav;
	}
}
