package ek.zhou.mapper;

import java.util.List;
import java.util.Map;

import ek.zhou.pojo.Category;
import ek.zhou.util.Page;

public interface CategoryMapper {
public int add(Category category);
public void delete(int id);
public int update(Category category);
public Category get(int id);
public List<Category> list(Map map);
//public List<Category> list(Page page);
//public int total();
}
