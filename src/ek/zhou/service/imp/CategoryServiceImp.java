package ek.zhou.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ek.zhou.mapper.CategoryMapper;
import ek.zhou.pojo.Category;
import ek.zhou.service.CategoryService;
import ek.zhou.util.Page;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<Category> list(String name) {
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("name", name);
		return categoryMapper.list(map);
	}

	@Override
	public void add(Category category) {
		categoryMapper.add(category);
	}

	@Override
	public Category get(Category category) {
		return categoryMapper.get(category.getId());
	}

	@Override
	public void delete(Category category) {
		categoryMapper.delete(category.getId());
	}

	@Override
	public void update(Category category) {
		categoryMapper.update(category);
	}

//	@Override
//	public List<Category> list(Page page) {
//		page.caculate(categoryMapper.total());
//		return categoryMapper.list(page);
//	}
	
}
