package com.socgen.employee.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.socgen.employee.model.Employee;

public interface EmployeeMgmtService {

	String saveEmployee(Employee employee);
	
	Page<Employee> getEmployeeList(Pageable pageable);
}
