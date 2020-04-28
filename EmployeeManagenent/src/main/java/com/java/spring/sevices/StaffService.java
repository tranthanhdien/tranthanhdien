package com.java.spring.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.java.spring.models.Depart;
import com.java.spring.models.Staff;

public interface StaffService {
	
	List<Depart> findAllDepart();

	void deleteAll();

	void deleteAll(List<Staff> entities);

	void delete(Staff entity);

	void deleteById(Long id);
	
	long count();

	List<Staff> findAllById(List<Long> ids);

	List<Staff> findAll();

	boolean existsById(Long id);

	Optional<Staff> findById(Long id);

	List<Staff> saveAll(List<Staff> entities);

	Staff save(Staff entity);
	
	List<Staff> findByNameLikeOrderByName(String name);

}
