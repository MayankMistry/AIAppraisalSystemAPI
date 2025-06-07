package com.mscit.develop.AIAppraisalSystemAPI.domain.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mscit.develop.AIAppraisalSystemAPI.domain.EmployeeService;
import com.mscit.develop.AIAppraisalSystemAPI.exception.EmployeeNotFoundException;
import com.mscit.develop.AIAppraisalSystemAPI.model.Employee;
import com.mscit.develop.AIAppraisalSystemAPI.model.login.response.LoginResponse;
import com.mscit.develop.AIAppraisalSystemAPI.model.response.EmployeeRes;
import com.mscit.develop.AIAppraisalSystemAPI.model.update.manager.request.UpdateManagerReq;
import com.mscit.develop.AIAppraisalSystemAPI.model.update.manager.response.UpdateManagerRes;

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

     public LoginResponse findbyUserName(Employee employee) {

          Employee employeeRes = employeeService.findByEmpUserName(employee.getEmpUserName());

          if (employeeRes == null) {

               throw new EmployeeNotFoundException("Invalid id and password");
          } else if (employeeRes.getPassword().equals(employee.getPassword())) {
               return LoginResponse.builder()
                         .message("Success")
                         .build();
          } else {
               throw new EmployeeNotFoundException("Invalid id and password");
          }

     }

     public List<Employee> getAllEmployees() {

          return employeeService.findAll();
     }

     public Employee createEmployee(Employee employee) {
          log.info("employee {}", employee.toString());
          return employeeService.save(employee);
     }

     public List<EmployeeRes> findAllManager() {

          List<Employee> managerList = employeeService.findByRole("MANAGER");
          List<EmployeeRes> employeeResult = managerList.stream().map(t -> EmployeeRes.builder()
                    .empUserName(t.getEmpUserName())
                    .firstName(t.getFirstName())
                    .lastName(t.getLastName())
                    .build())
                    .toList();

          if (employeeResult.isEmpty()) {
               throw new EmployeeNotFoundException("Manager Details not found");
          } else {
               return employeeResult;
          }
     }

     public List<EmployeeRes> findAllEmployees(String managerUserName) {

          List<Employee> employeeList = employeeService.findEmployeesByManagerUserName(managerUserName);
          if (employeeList.isEmpty()) {

               throw new EmployeeNotFoundException("Employee Details not found");
          } else {

               return employeeList.stream().map(t -> EmployeeRes.builder()
                         .empUserName(t.getEmpUserName())
                         .firstName(t.getFirstName())
                         .lastName(t.getLastName())
                         .empId(t.getEmpId())
                         .email(t.getEmail())
                         .mobileno(t.getMobileno())
                         .role(t.getRole())
                         .employeeDob(t.getEmployeeDob())
                         .employeeStartDate(t.getEmployeeStartDate())
                         .gender(t.getGender())
                         .employeeType(t.getEmployeeType())
                         .build())
                         .toList();
          }
     }

     @Transactional
     public UpdateManagerRes updateEmployeeManager(UpdateManagerReq managerReq) {

          employeeService.updateEmployeeManager(managerReq.empId(),
                    managerReq.empUserName(), managerReq.managerUserName());
          return UpdateManagerRes.builder()
                    .message("employee updated successfully")
                    .build();

     }

}
