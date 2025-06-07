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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mscit.develop.AIAppraisalSystemAPI.domain.AddressService;
import com.mscit.develop.AIAppraisalSystemAPI.domain.service.EmployeeServiceImpl;
import com.mscit.develop.AIAppraisalSystemAPI.model.Employee;
import com.mscit.develop.AIAppraisalSystemAPI.model.login.response.LoginResponse;
import com.mscit.develop.AIAppraisalSystemAPI.model.response.EmployeeRes;
import com.mscit.develop.AIAppraisalSystemAPI.model.update.manager.request.UpdateManagerReq;
import com.mscit.develop.AIAppraisalSystemAPI.model.update.manager.response.UpdateManagerRes;

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
     public ResponseEntity<List<EmployeeRes>> getAllEmployees(
               @RequestParam(name = "managerUserName") String managerUserName) {
          return new ResponseEntity<>(employeeServiceImpl.findAllEmployees(managerUserName),
                    HttpStatus.OK);
     }

     @GetMapping("/find-all-manager")
     public ResponseEntity<List<EmployeeRes>> findAllManager() {
          return new ResponseEntity<>(employeeServiceImpl.findAllManager(), HttpStatus.OK);
     }

     @PostMapping("/employee-login")
     public ResponseEntity<LoginResponse> employeeLogin(@RequestBody Employee employee) {
          return new ResponseEntity<>(employeeServiceImpl.findbyUserName(employee), HttpStatus.OK);
     }

     @PostMapping("/create-employee")
     public ResponseEntity<Employee> findbyUserName(@RequestBody Employee employee) {

          return new ResponseEntity<>(employeeServiceImpl.createEmployee(employee), HttpStatus.OK);
     }

     @PostMapping("/update-employee-manager")
     public ResponseEntity<UpdateManagerRes> updateEmployeeManager(@RequestBody UpdateManagerReq managerReq) {

          return new ResponseEntity<>(employeeServiceImpl.updateEmployeeManager(managerReq),
                    HttpStatus.OK);
     }

}
