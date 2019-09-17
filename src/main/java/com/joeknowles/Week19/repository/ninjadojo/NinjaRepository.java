package com.joeknowles.Week19.repository.ninjadojo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joeknowles.Week19.models.ninjadojo.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}
