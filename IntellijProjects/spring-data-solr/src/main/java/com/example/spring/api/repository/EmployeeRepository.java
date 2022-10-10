package com.example.spring.api.repository;

import com.example.spring.api.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer> {
    Employee findByName(String name);

//    @Query("SELECT * FROM employee e WHERE e.name LIKE CONCAT('%', :query, '%')")
    @Query("name:*?0*")
    Page<Employee> findEmployeeByName(String term, Pageable pageable);
}
