package com.java.spring.sevices;

import java.util.List;
import java.util.Optional;

import com.java.spring.models.Depart;

public interface DepartService {

	Depart save(Depart entity);

	List<Depart> saveAll(List<Depart> entities);

	Optional<Depart> findById(Integer id);

	boolean existsById(Integer id);

	List<Depart> findAll();

	List<Depart> findAllById(List<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(Depart entity);

	void deleteAll(List<Depart> entities);

	void deleteAll();
	
	List<Depart> findByNameLikeOrderByName(String name);

}
