package com.javaweb.customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// interface defined by Spring Data JPA
// this is almost the code we need for the data access layer
// As with Spring Data JPA, you don't have to write any DAO code. Just declare an interface that extends the CrudRepository interface, which defines CRUD methods like save(), findAll(), findById(),deleteById(), etc. At runtime, Spring Data JPA automatically generates the implementation code.
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'" + " OR c.address LIKE '%' || :keyword || '%'")
	public List<Customer> search(@Param("keyword") String keyword);
}