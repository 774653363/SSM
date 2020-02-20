package ek.zhou.service;

import java.util.List;

import ek.zhou.pojo.Product;

public interface ProductService {
	public List<Product> listByCid(Product product);

	public void add(Product product);

	public Product get(int id);

	public void update(Product product);

	public void delete(int id);
}
