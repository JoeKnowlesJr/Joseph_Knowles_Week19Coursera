package com.joeknowles.Week19.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joeknowles.Week19.models.prodcat.Category;
import com.joeknowles.Week19.models.prodcat.Product;
import com.joeknowles.Week19.repository.prodcat.CategoryRepository;
import com.joeknowles.Week19.repository.prodcat.ProductRepository;

@Service
public class ProdCatService {
	ProductRepository pRepo;
	CategoryRepository cRepo;
	
	public ProdCatService(ProductRepository p, CategoryRepository c) {pRepo = p; cRepo = c; }
	
	public Product saveProduct(Product p) { return pRepo.save(p); }
	public List<Product> allProducts() { return pRepo.findAll(); }
	public Optional<Product> findProductById(Long id) { return pRepo.findProductById(id); }
	public List<Category> allCategories() { return cRepo.findAll(); }
	public Optional<Category> findCategoryById(Long id) { return cRepo.findCategoryById(id); }
	
	public boolean createCategory(Category c) {
		try {
			cRepo.save(c);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	
	public boolean updateCategory(Category c) {
		try {
			cRepo.save(c);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
