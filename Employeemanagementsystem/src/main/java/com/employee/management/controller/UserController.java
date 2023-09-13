/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee.management.controller;

import com.employee.management.model.Employee;
import com.employee.management.serviceImp.Employeeserviceimp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
   
    @Autowired
     private Employeeserviceimp empsei;
    
    
    @PostMapping("/addemp")
    public ResponseEntity<Employee> addemployee(@RequestBody Employee employee){
        Employee emp=empsei.addEmployee(employee);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/deleteemp/{id}")
    public ResponseEntity<String> removeemployee(@PathVariable int id){
        empsei.removeEmployee(id);
        return new ResponseEntity<>("remove sucess",HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/findemp/{id}")
     public ResponseEntity<Optional<Employee>> findemployeebyid(@PathVariable int id){
         Optional<Employee> emps=empsei.findbyid(id);
         return new ResponseEntity<>(emps,HttpStatus.ACCEPTED);
     }
     
     @GetMapping("/all")
     public ResponseEntity<List<Employee>> listofemployee(){ 
         List<Employee> lemp=empsei.getallEmployee();
         return new ResponseEntity<>(lemp,HttpStatus.ACCEPTED);
     }
     
     @PutMapping("/update/{id}")
     public ResponseEntity<String> updateemployee(@PathVariable int id,@RequestBody Employee employee ){
        String a= empsei.updateEmployee(id, employee);
        return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
     }
}