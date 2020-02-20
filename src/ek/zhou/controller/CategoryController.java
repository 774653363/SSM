package ek.zhou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
		category = categoryService.get(category.getId());
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
	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category){
		System.out.println("SSM接受到服务器提交的json,并自动转换为Category对象:"+category);
		return "ok";
	}
	@ResponseBody
	@RequestMapping("/getOneCategory")
	public String getOneCategory(){
		Category c = new Category();
		c.setId(100);
		c.setName("第100个分类");
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("category", JSONObject.toJSON(c));
		return JSONObject.toJSON(c).toString();
	}
	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory(){
		List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }
		return JSONArray.toJSONString(cs);
	}
}
