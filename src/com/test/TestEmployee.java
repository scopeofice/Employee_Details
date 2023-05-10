package com.test;

import static com.util.IOUtil.restoreEmpDetails;
import static com.util.IOUtil.storeEmpDetails;
import static com.util.ValidationRules.validateAllInputs;
import static com.util.ValidationRules.validateAndPromote;
import static com.util.ValidationRules.validateAndRemove;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.app.code.Employee;

public class TestEmployee {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Employee> employeeList = restoreEmpDetails("emplist");
			boolean exit = false;
			while (!exit) {
				System.out.println(" ");
				System.out.println("1. Hire new emp");
				System.out.println("2. List all emp details");
				System.out.println("3. Promote an emp");
				System.out.println("4. Delete emp details");
				System.out.println("5. Sort emps as per join date n display the same.");
				System.out.println("0. Exit");
				System.out.println("Enter Choice");
				try {
					switch (sc.next()) {
					case "1":
						System.out.println(
								"Enter Details : Id, First Name, Last Name, Department Name, Date Of Joining, Salary");
						Employee e = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), employeeList);
						employeeList.put(e.getId(), e);
						break;
					case "2":
						System.out.println("List of all employees :");
						employeeList.values().stream().forEach(System.out::println);
						break;
					case "3":
						System.out.println("Enter Id of the Employee :");
						String empid = sc.next();
						System.out.println("Enter new designation");
						String designation=sc.next();
						employeeList.values().stream().filter(null);
						validateAndPromote(empid,designation,employeeList);
						
						break;
					case "4":
						System.out.println("Enter employee id : ");
						empid = sc.next();
						validateAndRemove(empid, employeeList);
						break;
					case "5":
						System.out.println("Employee List");
						employeeList.values().stream().sorted((k, v) -> k.getDoj().compareTo(v.getDoj()))
								.forEach(System.out::println);
						break;
					case "0":
						System.out.print("Exiting...");
						exit = true;
						storeEmpDetails("emplist", employeeList);
						break;
					default:
						System.out.print("Invalid chooce");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

	}

}
