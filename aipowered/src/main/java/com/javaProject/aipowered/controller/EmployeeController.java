package com.javaProject.aipowered.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.javaProject.aipowered.dto.EmployeeDTO;
import com.javaProject.aipowered.entity.EmployeeEntity;

import com.javaProject.aipowered.service.EmployeeService;



@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/test")
	public String test() {
	    return "Working";
	}
	@PostMapping
	public EmployeeEntity addEmployee( @RequestBody EmployeeDTO dto) {
		return employeeService.addEmployee(dto);
	}
	@GetMapping
	public List<EmployeeEntity> getEmployee() {
		return employeeService.getAll();
	}
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
	    employeeService.deleteEmployeeId(id);
	    return "Employee deleted successfully";
	}
}

