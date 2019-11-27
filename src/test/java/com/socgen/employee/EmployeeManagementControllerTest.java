package com.socgen.employee;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.socgen.employee.constant.Constants;
import com.socgen.employee.controller.EmployeeMgmtController;
import com.socgen.employee.repository.EmployeeMgmtRepo;
import com.socgen.employee.service.EmployeeMgmtService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeMgmtController.class)
public class EmployeeManagementControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeMgmtRepo repository;

	@MockBean
	private EmployeeMgmtService service;

	@Test
	public void createEmployeeTest() throws Exception {
		String employee = "{\"firstName\":\"Test\",\"lastName\":\"Employee\",\"gender\":\"Male\",\"department\":\"TestDept\"}";

		Mockito.when(service.saveEmployee(Mockito.any())).thenReturn(Constants.SAVED_SUCCESS);

		mockMvc.perform(post("/employee/create").contentType(MediaType.APPLICATION_JSON).content(employee))
				.andExpect(status().isCreated()).andReturn();
	}

	@Test
	public void getEmployeeListTest() throws Exception {

		Mockito.when(service.getEmployeeList(Pageable.unpaged())).thenReturn(null);

		mockMvc.perform(get("/employee/getList")).andExpect(status().isOk()).andReturn();
	}

}
