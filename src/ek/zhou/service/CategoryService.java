package ek.zhou.service;

import java.util.List;

import ek.zhou.pojo.Category;
import ek.zhou.util.Page;

public interface CategoryService {
List<Category> list(String name);
//List<Category> list(Page page);

void add(Category category);

Category get(Category category);

void delete(Category category);

void update(Category category);
}
