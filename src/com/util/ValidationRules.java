package com.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import com.app.code.Dept;
import com.app.code.Employee;
import com.exp.DuplicateEmployeeException;
import com.exp.EmployeeNotFoundException;
import com.exp.InvalidDepartmentException;
import com.exp.WrongDataInputException;

public class ValidationRules {
	public static Employee validateAllInputs(String id, String fName, String lName, String dept, String doj, double salary,Map<String,Employee> employeeList) throws WrongDataInputException, EmployeeNotFoundException, InvalidDepartmentException, DuplicateEmployeeException {
		validateDupId(id,employeeList);
		Dept dep=parseAndValidateDept(dept);
		LocalDate joining = parseAndValidateDate(doj);
		return new Employee (id,fName,lName,dep,joining,salary);
	}
	
	public static LocalDate parseAndValidateDate(String doj) throws WrongDataInputException {
		LocalDate newDate=LocalDate.parse(doj);
		if(Period.between(newDate, LocalDate.now()).toTotalMonths()>36)
			throw new WrongDataInputException("Wrong Date");
		return newDate;
	}

	public static Dept parseAndValidateDept(String dept) throws InvalidDepartmentException {
		return Dept.valueOf(dept.toUpperCase());
	}

	public static void validateDupId(String id, Map<String,Employee> employeeList) throws DuplicateEmployeeException   {
		if(employeeList.containsKey(id))
			throw new DuplicateEmployeeException("Employee already present");	
	}
	
	public static String validateEmpIdAndPromote(String id, Map<String,Employee> employeeList) throws EmployeeNotFoundException {
		if(!employeeList.containsKey(id))
			throw new EmployeeNotFoundException("No such employee");
		return id;	
	}
	
	public static void validateAndPromote(String id,String designation, Map<String,Employee> employeeList) throws EmployeeNotFoundException, InvalidDepartmentException {
		if(!employeeList.containsKey(id))
			throw new EmployeeNotFoundException("No such employee");
		employeeList.get(id).setSalary(employeeList.get(id).getSalary()+5000);
		Dept dep=parseAndValidateDept(designation);
		employeeList.get(id).setDept(dep);
		System.out.println("Employee id :"+id+" Name : "+employeeList.get(id).getfName()+" New Salary : "+employeeList.get(id).getSalary());
	}
	public static void validateAndRemove(String id, Map<String,Employee> employeeList) throws EmployeeNotFoundException {
		if(!employeeList.containsKey(id))
			throw new EmployeeNotFoundException("No such employee");
		employeeList.remove(id);		
		System.out.println("Employee id :"+id+"Removed from the list");
	}
	
}
