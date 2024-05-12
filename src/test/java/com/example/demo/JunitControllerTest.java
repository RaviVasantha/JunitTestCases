package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitControllerTest {
	@Mock
	private EmployeeService es;
	@InjectMocks
	private EmployeeController ec;
	
	@Test
	public void testSaveAll() {
		List<Employee> employees=new ArrayList<>();
		Employee e1=new Employee();
		e1.setName("sriram");
		e1.setRole("support");
		e1.setAge(23);
		e1.setSalary(25000);
		employees.add(e1);
		Employee e2=new Employee();
		e1.setName("Ravichandran");
		e1.setRole("support");
		e1.setAge(24);
		e1.setSalary(26000);
		employees.add(e2);
		when(es.saveAll(employees)).thenReturn(employees);
		assertEquals(employees, ec.saveAll(employees));
	}
	@Test
	public void testFindById() {
		long id=1L;
		Employee employee=new Employee();
		employee.setId(id);
		employee.setName("ashok");
		employee.setRole("developer");
		employee.setAge(30);
		employee.setSalary(45000);
		when(es.findById(id)).thenReturn(employee);
		assertEquals(employee, ec.findById(id));
	}
	
	@Test
	public void testFindAll() {
	List<Employee> emp=new ArrayList<>();
	Employee e1=new Employee();
	e1.setName("sriram");
	e1.setRole("support");
	e1.setAge(23);
	e1.setSalary(25000);
	emp.add(e1);
	Employee e2=new Employee();
	e1.setName("Ravichandran");
	e1.setRole("support");
	e1.setAge(24);
	e1.setSalary(26000);
	emp.add(e2);
	when(es.findAll()).thenReturn(emp);
	List<Employee> foundEmployee=ec.findAll();
	assertEquals(emp, foundEmployee);
	}
	@Test
	public void testDeleteById() {
		long id=1L;
		when(es.deleteById(id)).thenReturn("success");
		assertEquals("success", ec.deleteById(id));
	}
	@Test
	public void testDeleteAll() {
		when(es.deleteAll()).thenReturn("success");
		assertEquals("success", ec.deleteAll());
	}
	@Test
	public void testReplaceById() {
		long id=1L;
		Employee empo=new Employee();
		empo.setId(id);
		empo.setName("kanishka");
		empo.setRole("preKG");
		empo.setAge(2);
		empo.setSalary(200000);
		when(es.replacebyid(id, empo)).thenReturn("Success");
		assertEquals("Success", ec.replacebyid(id, empo));
		
	}
	@Test
	public void testReplace() {
		long id=1L;
		Employee emps=new Employee();
		emps.setId(id);
		emps.setName("priya");
		emps.setRole("kaniAsst");
		emps.setAge(20);
		emps.setSalary(10000);
		when(es.replace(emps, id)).thenReturn("success");
		assertEquals("success", ec.replace(id, emps));
	}
	@Test
	public void testSave() {
		Employee empss=new Employee();
		empss.setName("bharath");
		empss.setRole("testing");
		empss.setAge(27);
		empss.setSalary(30000);
		when(es.save(empss)).thenReturn("Success");
		assertEquals("Success", ec.save(empss));
	}

}
