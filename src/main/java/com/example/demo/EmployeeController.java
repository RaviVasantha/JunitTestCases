package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
    @Autowired
    EmployeeService es;
    @PostMapping(value="/save")
    public String save(@RequestBody Employee e) {
    	return es.save(e);
    }

    @PostMapping(value="/saveAll")
    public List<Employee> saveAll(@RequestBody List<Employee> employees) {
        return es.saveAll(employees);
    }

    @GetMapping(value="/findById/{id}")
    public Employee findById(@PathVariable long id) {
        return es.findById(id);
    }

    @GetMapping(value="/findAll")
    public List<Employee> findAll() {
        return es.findAll();
    }

    @DeleteMapping(value="/deleteAll")
    public String deleteAll() {
        return es.deleteAll();
    }

    @DeleteMapping(value="/deleteById/{id}")
    public String deleteById(@PathVariable long id) {
        return es.deleteById(id);
    }

	@PutMapping(value="/replacebyid/{id}")
	public String replacebyid(@PathVariable long id,@RequestBody Employee emp) {
		return es.replacebyid(id,emp);
    }

    @PatchMapping(value="/replace/{id}")
    public String replace(@PathVariable long id, @RequestBody Employee e) {
        return es.replace(e, id);
    }

    @GetMapping(value="/getAll")
	public String getAll(@RequestBody Employee e,@RequestParam long id,@RequestParam String name,@RequestParam String role,@RequestParam int age,@RequestParam int salary) {
		return es.getAll(e,id,name,role,age,salary);
    }
}
