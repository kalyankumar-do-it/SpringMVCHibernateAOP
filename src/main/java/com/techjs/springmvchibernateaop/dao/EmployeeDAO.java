package com.techjs.springmvchibernateaop.dao;

import java.util.List;

import com.techjs.springmvchibernateaop.entity.Employee;

public interface EmployeeDAO 
{
	 List<Employee> getAllEmployees();
	    void saveEmployee(Employee employee);
	    Employee getEmployee(int id);
	    void deleteEmployee(int id);
}
