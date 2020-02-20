package ek.zhou.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ek.zhou.mapper.ProductMapper;
import ek.zhou.pojo.Product;
import ek.zhou.service.ProductService;
@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	ProductMapper productMapper;
	@Override
	public List<Product> listByCid(Product product) {
		return productMapper.listByCid(product);
	}
	@Override
	public void add(Product product) {
		productMapper.add(product);
	}
	@Override
	public Product get(int id) {
		return productMapper.get(id);
	}
	@Override
	public void update(Product product) {
		productMapper.update(product);
	}
	@Override
	public void delete(int id) {
		productMapper.delete(id);
	}

}
