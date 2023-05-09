package com.app.code;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable{
	private String id;
	private String fName;
	private String lName;
	private Dept dept;
	private LocalDate doj;
	private double salary;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", dept=" + dept + ", doj=" + doj
				+ ", salary=" + salary + "]";
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public Employee(String id, String fName, String lName, Dept dept, LocalDate doj, double salary) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.dept = dept;
		this.doj = doj;
		this.salary = salary;
	}
	
}
