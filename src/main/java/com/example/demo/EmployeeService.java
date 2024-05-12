package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo er;
    public String save(Employee e) {
    	er.save(e);
    	return "success";
    }

    public List<Employee> saveAll(List<Employee> employees) {
        return er.saveAll(employees);
    }

    public Employee findById(long id) {
        return er.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return er.findAll();
    }

    public String deleteAll() {
        er.deleteAll();
        return "success";
    }

    public String deleteById(long id) {
        er.deleteById(id);
        return "success";
    }

	public String replacebyid(long id,Employee emp) {
	return er.findById(id).map(x->{
		x.setName(emp.getName());
		x.setRole(emp.getRole());
		x.setSalary(emp.getSalary());
		er.save(x);
		return "success";
	}).orElse("entity not found");
			
	}

    public String replace(Employee e,long id) {
		Employee em=er.findById(id).get();
		em.setAge(e.getAge());
		er.save(em);
		return "success";	
	}

    public String getAll(Employee e,long id,String name,String role,int age,int salary) {
		e.setId(id);
		e.setName(name);
		e.setRole(role);
		e.setAge(age);
		e.setSalary(salary);
		return "EmployeeDetails:"+id+"_"+name+"_"+role+"_"+age+"_"+salary;
    }
}
