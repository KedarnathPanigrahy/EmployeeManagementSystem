package com.socgen.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socgen.employee.constant.Constants;
import com.socgen.employee.model.Employee;
import com.socgen.employee.repository.EmployeeMgmtRepo;
import com.socgen.employee.service.EmployeeMgmtService;

@Service
@Transactional
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeMgmtRepo repository;

	@Override
	public String saveEmployee(Employee employeeData) {
		Employee employee = repository.getEmployeeDetailsByName(employeeData.getFirstName(),
				employeeData.getLastName());

		if (employee != null) {
			return Constants.EMPLOYEE_DETAILS_EXIST;

		}

		repository.save(employeeData);
		return Constants.SAVED_SUCCESS;

	}

	@Override
	public Page<Employee> getEmployeeList(Pageable pageable) {
		return repository.getEmployeeList(pageable);
	}
}
