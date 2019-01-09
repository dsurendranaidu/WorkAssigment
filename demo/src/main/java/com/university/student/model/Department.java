package com.university.student.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
@Table(name = "department")
public class Department {
	
	@Id
	@Column(name="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long department_id;
	
    @NotBlank
    @Column(name="department_name")
	private String department_name;
    
    @NotBlank
    @Column(name="department_head")
	private String department_head;
    

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_head() {
		return department_head;
	}

	public void setDepartment_head(String department_head) {
		this.department_head = department_head;
	}
    
}
