package com.tus.department.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Long id;

	@Column(name = "org_id")
	private Long organizationId;
	
	@Column(name = "dept_name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "department_employees",
		joinColumns=@JoinColumn(name="department_id"),
		inverseJoinColumns=@JoinColumn(name="employee_id"))
	private List<Employee> employees;
}
