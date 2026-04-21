package com.javaProject.aipowered.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaProject.aipowered.dto.EmployeeDTO;
import com.javaProject.aipowered.entity.EmployeeEntity;
import com.javaProject.aipowered.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	public EmployeeEntity addEmployee(EmployeeDTO dto) {
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setName(dto.getName());
		employeeEntity.setRole(dto.getRole());
		
		return repo.save(employeeEntity);
	}
	
	public List<EmployeeEntity> getAll(){
		return repo.findAll();
	}
	public void deleteEmployeeId(Long id) {
		repo.deleteById(id);
	}
}
