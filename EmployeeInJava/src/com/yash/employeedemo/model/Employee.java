package com.yash.employeedemo.model;

public class Employee {
	
	private Integer id;
	private String name;
	private double salary;
	private String address;
	
	public Employee() {
	}
	
	public Employee(String name, double salary, String address) {
		super();
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}