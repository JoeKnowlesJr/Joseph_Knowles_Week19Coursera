package com.joeknowles.Week19.repository.overflow;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joeknowles.Week19.models.overflow.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
}
