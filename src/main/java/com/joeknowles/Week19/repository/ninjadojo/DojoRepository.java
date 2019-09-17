package com.joeknowles.Week19.repository.ninjadojo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joeknowles.Week19.models.ninjadojo.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
