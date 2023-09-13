/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.employee.management.service;

import com.employee.management.model.Employee;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author acer
 */
public interface Employeeservice {
     public Employee addEmployee(Employee employee);
    
    public String removeEmployee(int id);
   
    public Optional<Employee> findbyid(int id);
    
    public List<Employee> getallEmployee();
    public String updateEmployee(int id,Employee employee);
}
