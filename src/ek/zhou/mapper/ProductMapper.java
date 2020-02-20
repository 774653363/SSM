package ek.zhou.mapper;

import java.util.List;

import ek.zhou.pojo.Product;

public interface ProductMapper {
public List<Product> listByCid(Product product);
public int add(Product product);
public void delete(int id);
public int update(Product product);
public Product get(int id);
}
