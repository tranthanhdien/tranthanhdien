package com.java.spring.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.models.Depart;
import com.java.spring.repositories.DepartRepository;

// lớp này sẽ thực hiện các thao tác liên quan đến Service
@Service
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartRepository departRepository;

	public Depart save(Depart entity) {
		return departRepository.save(entity);
	}

	public List<Depart> saveAll(List<Depart> entities) {
		return (List<Depart>) departRepository.saveAll(entities);
	}

	public Optional<Depart> findById(Integer id) {
		return departRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return departRepository.existsById(id);
	}

	public List<Depart> findAll() {
		return (List<Depart>) departRepository.findAll();
	}

	public List<Depart> findAllById(List<Integer> ids) {
		return (List<Depart>) departRepository.findAllById(ids);
	}

	// phuong thuc dc them vao
	public List<Depart> findByNameLikeOrderByName(String name) {
		// % cho phép tìm kiếm theo dạng like
		return departRepository.findByNameLikeOrderByName("%" + name + "%");
	}

	public long count() {
		return departRepository.count();
	}

	public void deleteById(Integer id) {
		departRepository.deleteById(id);
	}

	public void delete(Depart entity) {
		departRepository.delete(entity);
	}

	public void deleteAll(List<Depart> entities) {
		departRepository.deleteAll(entities);
	}

	public void deleteAll() {
		departRepository.deleteAll();
	}

}
