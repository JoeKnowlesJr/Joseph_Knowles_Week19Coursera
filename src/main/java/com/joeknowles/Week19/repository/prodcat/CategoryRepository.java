package com.joeknowles.Week19.repository.prodcat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joeknowles.Week19.models.prodcat.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	public List<Category> findAll();
	public Optional<Category> findCategoryById(Long id);
}
