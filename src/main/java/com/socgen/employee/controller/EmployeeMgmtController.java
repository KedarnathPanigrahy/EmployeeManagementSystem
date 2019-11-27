package com.socgen.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.employee.model.Employee;
import com.socgen.employee.service.EmployeeMgmtService;

@RestController
@RequestMapping("/employee")
public class EmployeeMgmtController {

	@Autowired
	EmployeeMgmtService service;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/getList")
	public ResponseEntity<Employee> getEmployeeList(Pageable pageable) {
		return new ResponseEntity(service.getEmployeeList(pageable), HttpStatus.OK) ;
	}
}
