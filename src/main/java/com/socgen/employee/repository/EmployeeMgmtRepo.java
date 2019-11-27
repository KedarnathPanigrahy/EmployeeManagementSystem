package com.socgen.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socgen.employee.model.Employee;

@Repository
public interface EmployeeMgmtRepo extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE firstName=:firstName AND lastName=:lastName")
	Employee getEmployeeDetailsByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query("SELECT e FROM Employee e ORDER BY firstName ASC")
	Page<Employee> getEmployeeList(Pageable pageable);
	
	
}
