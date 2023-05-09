package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.code.Employee;

public interface IOUtil {
	static void storeEmpDetails(String fileName, Map<String, Employee> employeeList)
			throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(employeeList);// serialization
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	static Map<String, Employee> restoreEmpDetails(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Map<String, Employee>) in.readObject();
		} catch (ClassNotFoundException e) {
			return new HashMap<String, Employee>();
		}
	}
}
