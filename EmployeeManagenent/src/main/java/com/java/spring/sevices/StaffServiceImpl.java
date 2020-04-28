package com.java.spring.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.models.Depart;
import com.java.spring.models.Staff;
import com.java.spring.repositories.DepartRepository;
import com.java.spring.repositories.StaffRepository;

//lớp này sẽ thực hiện các thao tác liên quan đến Service
@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private DepartRepository departRepository;

	// danh sách các Depart
	public List<Depart> findAllDepart() {
		return (List<Depart>) departRepository.findAll();
	}

	@Override
	public Staff save(Staff entity) {
		return staffRepository.save(entity);
	}

	@Override
	public List<Staff> saveAll(List<Staff> entities) {
		return (List<Staff>) staffRepository.saveAll(entities);
	}

	@Override
	public Optional<Staff> findById(Long id) {
		return staffRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return staffRepository.existsById(id);
	}

	@Override
	public List<Staff> findAll() {
		return (List<Staff>) staffRepository.findAll();
	}

	@Override
	public List<Staff> findAllById(List<Long> ids) {
		return (List<Staff>) staffRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return staffRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void delete(Staff entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Staff> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}

	// phuong thuc dc them vao
	@Override
	public List<Staff> findByNameLikeOrderByName(String name) {
		// % cho phép tìm kiếm theo dạng like
		return staffRepository.findByNameLikeOrderByName("%" + name + "%");
	}


}
