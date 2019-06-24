package com.raman.data;

import java.util.List;
import com.raman.model.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee employee) throws Exception;
	List<Employee> findAll() throws Exception;
	Employee findById(int id)throws Exception;
	List<Employee> findByName(String name)throws Exception;
	void updateSalary(int id,double salary)throws Exception;
	void deleteEmployee(int id)throws Exception;
	void updateEmployee(Employee employee)throws Exception;
	
	
	

}
