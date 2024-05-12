package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitServiceTest {
	
	@Mock
	private EmployeeRepo er;
	@InjectMocks
    private EmployeeService es;
	
	@Test
	public void testSaveAll() {
		List<Employee> employees = new ArrayList<>();
        
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("John");
        employee1.setRole("Developer");
        employee1.setAge(30);
        employee1.setSalary(50000);
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Alice");
        employee2.setRole("Manager");
        employee2.setAge(35);
        employee2.setSalary(60000);
        employees.add(employee2);
        when(er.saveAll(employees)).thenReturn(employees);
        List<Employee> savedEmployees = es.saveAll(employees);
        assertEquals(employees, savedEmployees);
    }
	@Test
    public void testFindById() {
        long id = 1L;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("John");
        employee.setRole("Developer");
        employee.setAge(30);
        employee.setSalary(50000);

        when(er.findById(id)).thenReturn(Optional.of(employee));

        assertEquals(employee, es.findById(id));
    }
	@Test
    public void testFindAll() {
        List<Employee> employees = new ArrayList<>();
    
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("John");
        employee1.setRole("Developer");
        employee1.setAge(30);
        employee1.setSalary(50000);
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Alice");
        employee2.setRole("Manager");
        employee2.setAge(35);
        employee2.setSalary(60000);
        employees.add(employee2);

        when(er.findAll()).thenReturn(employees);

        List<Employee> foundEmployees = es.findAll();

        assertEquals(employees, foundEmployees);
    }
	@Test
   public void testDeleteAll() {
        assertEquals("success", es.deleteAll());
        verify(er, times(1)).deleteAll();
    }
	public void testDeleteById() {
		long id=1L;
		assertEquals("success", es.deleteById(id));
		verify(er,times(1)).deleteById(id);
	}
	@Test
    void testSave() {
        Employee employee = new Employee();
        employee.setName("John");
        employee.setRole("Developer");
        employee.setAge(30);
        employee.setSalary(50000);

        assertEquals("success", es.save(employee));

        verify(er, times(1)).save(employee);
    }
	
	}
