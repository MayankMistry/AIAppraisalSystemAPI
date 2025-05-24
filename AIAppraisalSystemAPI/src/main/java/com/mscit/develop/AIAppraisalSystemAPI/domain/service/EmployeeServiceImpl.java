package com.mscit.develop.AIAppraisalSystemAPI.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.mscit.develop.AIAppraisalSystemAPI.domain.EmployeeService;
//import com.mscit.develop.AIAppraisalSystemAPI.exception.EmployeeNotFoundException;
import com.mscit.develop.AIAppraisalSystemAPI.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl {

     @Autowired
     @Lazy
     private EmployeeService employeeService;

     public Optional<Employee> getEmployeeById(Long empId) {

          return employeeService.findById(empId);
     }

     // public Employee findbyUserName(String empUserName, String passWord) {
     // Optional<Employee> employee = employeeService.findbyUserName(empUserName);
     // if (!employee.isEmpty() && employee.get().getPassword().equals(passWord)) {
     // return employee.get();
     // } else {
     // throw new EmployeeNotFoundException("Employee Not Found");
     // }
     // }

     public List<Employee> getAllEmployees() {

          return employeeService.findAll();
     }

     public Employee createEmployee(Employee employee) {
          log.info("employee {}", employee.toString());
          return employeeService.save(employee);
     }

}
