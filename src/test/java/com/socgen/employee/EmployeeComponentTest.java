package com.socgen.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.socgen.employee.constant.Constants;
import com.socgen.employee.model.Employee;
import com.socgen.employee.repository.EmployeeMgmtRepo;
import com.socgen.employee.service.EmployeeMgmtService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.socgen.employee")
public class EmployeeComponentTest {

	@Autowired
	private TestEntityManager entityManager;

	@Mock
	private EmployeeMgmtRepo repository;

	@Autowired
	private EmployeeMgmtService service;

	@Test
	public void saveEmployeeTest() {
		Employee employeeObj = new Employee();
		employeeObj.setDateOfBirth(new Date());
		employeeObj.setDepartment("testDept");
		employeeObj.setFirstName("testEmployee");
		employeeObj.setGender("Male");
		employeeObj.setLastName("test");

		String result = service.saveEmployee(employeeObj);
		assertEquals(Constants.SAVED_SUCCESS, result);
	}

	@Test
	public void saveEmployeeWithDuplicateRecordTest() {
		saveEmployeesData();

		Page<Employee> employees = service.getEmployeeList(Pageable.unpaged());

		assertEquals(2, employees.getContent().size());
	}

	@Test
	public void getEmployeeListTest() {
		Employee employeeObj = new Employee();
		employeeObj.setDateOfBirth(new Date());
		employeeObj.setDepartment("testDept");
		employeeObj.setFirstName("testEmployee");
		employeeObj.setGender("Male");
		employeeObj.setLastName("test");

		employeeObj = entityManager.persist(employeeObj);

		String result = service.saveEmployee(employeeObj);
		assertEquals(Constants.EMPLOYEE_DETAILS_EXIST, result);
	}

	private void saveEmployeesData() {
		Employee employeeOne = new Employee();
		employeeOne.setDateOfBirth(new Date());
		employeeOne.setDepartment("testDept");
		employeeOne.setFirstName("employeeOne");
		employeeOne.setGender("Male");
		employeeOne.setLastName("test");

		Employee employeeTwo = new Employee();
		employeeTwo.setDateOfBirth(new Date());
		employeeTwo.setDepartment("testDept");
		employeeTwo.setFirstName("employeeTwo");
		employeeTwo.setGender("Male");
		employeeTwo.setLastName("test");

		entityManager.persist(employeeOne);
		entityManager.persist(employeeTwo);
	}
}
