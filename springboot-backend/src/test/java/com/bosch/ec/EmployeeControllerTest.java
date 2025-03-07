package com.bosch.ec;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeController employeeController;

	private Employee employee;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		employee = new Employee("John", "Doe", "john.doe@example.com");
	}
	//Asar latest commit
	@Test
	public void testGetAllEmployees() throws Exception {
		when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
		mockMvc.perform(get("/api/v1/employees"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstName").value(employee.getFirstName()));
	}

	@Test
	public void testCreateEmployee() throws Exception {
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
		mockMvc.perform(post("/api/v1/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"emailId\":\"john.doe@example.com\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value(employee.getFirstName()));
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
		mockMvc.perform(get("/api/v1/employees/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value(employee.getFirstName()));
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
		mockMvc.perform(put("/api/v1/employees/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"emailId\":\"john.doe@example.com\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value(employee.getFirstName()));
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
		doNothing().when(employeeRepository).delete(any(Employee.class));
		mockMvc.perform(delete("/api/v1/employees/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.deleted").value(true));
	}
}