package com.java.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.models.Depart;
import java.lang.String;
import java.util.List;

// đánh dấu cho Spring biết đây là Repository
// thực hiện các thao tác CRUD với CSDL
@Repository
public interface DepartRepository extends CrudRepository<Depart, Integer> {
	// bổ sung pthuc tìm kiếm theo tên
	List<Depart> findByNameLikeOrderByName(String name);

}
