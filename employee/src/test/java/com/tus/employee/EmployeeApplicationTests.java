package com.tus.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.tus.employee.entity.Employee;

@SpringBootTest
class EmployeeApplicationTests {
	
	@Autowired
    TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}
	
	@Test
    void findAll() {
        Employee[] employees = restTemplate.getForObject("/", Employee[].class);
        Assertions.assertTrue(employees.length > 0);
    }
	
	@Test
    void findById() {
        Employee employee = restTemplate.getForObject("/{id}", Employee.class, 1L);
        Assertions.assertNotNull(employee);
        Assertions.assertNotNull(employee.getId());
        Assertions.assertNotNull(employee.getName());
        Assertions.assertEquals(1L, employee.getId());
    }
	
	 @Test
	    void findByOrganization() {
	        Employee[] employees = restTemplate.getForObject("/organization/{organizationId}", Employee[].class, 1L);
	        Assertions.assertTrue(employees.length > 0);
	    }

	    @Test
	    void findByDepartment() {
	        Employee[] employees = restTemplate.getForObject("/department/{departmentId}", Employee[].class, 1L);
	        Assertions.assertTrue(employees.length > 0);
	    }

	    @Test
	    void add() {
	        Employee employee = new Employee();
	        long empId=1;
	        long depId=3;
	        employee.setId(empId);
	        employee.setAge(28);
	        employee.setDepartmentId(depId);
	        employee.setOrganizationId(5L);
	        employee.setPosition("Student");
	        employee.setName("Varsha");
	        
	        employee = restTemplate.postForObject("/", employee, Employee.class);
	        Assertions.assertNotNull(employee);
	        Assertions.assertNotNull(employee.getId());
	        Assertions.assertNotNull(employee.getName());
	    }
}
