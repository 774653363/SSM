package ek.zhou.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public Category get(int id) {
		return categoryMapper.get(id);
	}

	@Override
	public void delete(Category category) {
		categoryMapper.delete(category.getId());
	}

	@Override
	public void update(Category category) {
		categoryMapper.update(category);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void addTwo() {
		Category c1 = new Category();
        c1.setName("短的名字");
        categoryMapper.add(c1);
         
        Category c2 = new Category();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.add(c2);
	}

	@Override
	public void deleteAll() {
		Map<String, Object> map = new HashMap<>();
		List<Category> cs = categoryMapper.list(map);
		for(Category c:cs){
			delete(c);
		}
	}

//	@Override
//	public List<Category> list(Page page) {
//		page.caculate(categoryMapper.total());
//		return categoryMapper.list(page);
//	}
	
}
