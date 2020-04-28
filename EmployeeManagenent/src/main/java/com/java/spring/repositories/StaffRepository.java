package com.java.spring.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.models.Staff;

//đánh dấu cho Spring biết đây là Repository
//thực hiện các thao tác CRUD với CSDL
@Repository
public interface StaffRepository extends CrudRepository<Staff, Long>, JpaRepository<Staff, Long> {
	
	List<Staff> findByNameLikeOrderByName(String name);
	
	@Query("SELECT e FROM Staff e")
	Page<Staff> findStaffs(Pageable pageable);
	
	@Query("SELECT COUNT(s.id) FROM Staff s")
	int countStaff();

}
