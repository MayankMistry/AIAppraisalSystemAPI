package com.mscit.develop.AIAppraisalSystemAPI.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscit.develop.AIAppraisalSystemAPI.domain.AddressService;
import com.mscit.develop.AIAppraisalSystemAPI.domain.service.EmployeeServiceImpl;
import com.mscit.develop.AIAppraisalSystemAPI.model.Employee;

@RestController
@RequestMapping("/employee-appraisal-system")
public class EmployeeController {

     @Autowired
     private EmployeeServiceImpl employeeServiceImpl;

     @Autowired
     private AddressService addressService;

     @GetMapping("/find-employee/{empId}")
     public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(name = "empId") String empId) {
          return new ResponseEntity<>(employeeServiceImpl.getEmployeeById(Long.parseLong(empId)), HttpStatus.OK);
     }

     @GetMapping("/find-all-employee")
     public ResponseEntity<List<Employee>> getAllEmployees() {
          return new ResponseEntity<>(employeeServiceImpl.getAllEmployees(), HttpStatus.OK);
     }

     // @PostMapping("/find-by-username")
     // public ResponseEntity<Employee> findbyUserName(@RequestParam(name =
     // "empUserName") String empUserName,
     // @RequestParam(name = "passWord") String passWord) {
     // Employee employee = employeeServiceImpl.findbyUserName(empUserName,
     // passWord);
     // return new ResponseEntity<>(employee, HttpStatus.OK);
     // }

     @PostMapping("/create-employee")
     public ResponseEntity<Employee> findbyUserName(@RequestBody Employee employee) {

          return new ResponseEntity<>(employeeServiceImpl.createEmployee(employee), HttpStatus.OK);
     }

}
