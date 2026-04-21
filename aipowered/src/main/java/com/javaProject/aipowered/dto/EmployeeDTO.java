package com.javaProject.aipowered.dto;

import org.antlr.v4.runtime.misc.NotNull;

import lombok.Data;

@Data
public class EmployeeDTO {
	@NotNull
    private String name;
	@NotNull
    private String role;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}
