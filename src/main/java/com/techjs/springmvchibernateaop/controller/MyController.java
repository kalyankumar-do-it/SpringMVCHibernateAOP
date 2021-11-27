package com.techjs.springmvchibernateaop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.techjs.springmvchibernateaop.entity.Employee;
import com.techjs.springmvchibernateaop.service.EmployeeService;


@Controller
public class MyController 
{

	@Autowired
    private EmployeeService service;
	
	@RequestMapping("/")
    public String showAllEmployees(Model model) 
	{
        List<Employee> allEmployees = service.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all_employees";
    }
	
	@RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) 
	{
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee_info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) 
    {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) 
    {
        Employee employee = service.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee_info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) 
    {
      service.deleteEmployee(id);
        return "redirect:/";
    }
}
