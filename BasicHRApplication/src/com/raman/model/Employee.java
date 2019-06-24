package com.raman.model;

public class Employee {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String department;
	private double salary;
	

	
	public Employee(int id, String first_name, String last_name, String email, String department, double salary) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
	
	
	public Employee(String first_name, String last_name, String email, String department, double salary) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", department=" + department + ", salary=" + salary + "]";
	}
	
	
	
	}

