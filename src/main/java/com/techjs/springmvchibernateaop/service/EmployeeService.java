package com.techjs.springmvchibernateaop.service;

import java.util.List;
import com.techjs.springmvchibernateaop.entity.Employee;

public interface EmployeeService 
{
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployee(int id);
	void deleteEmployee(int id);
}
