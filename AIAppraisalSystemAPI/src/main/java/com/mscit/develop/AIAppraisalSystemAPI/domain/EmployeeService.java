package com.mscit.develop.AIAppraisalSystemAPI.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mscit.develop.AIAppraisalSystemAPI.model.Employee;

public interface EmployeeService extends JpaRepository<Employee, Long> {

    Employee findByEmpUserName(String empUserName);

    List<Employee> findByRole(String role);

    List<Employee> findEmployeesByManagerUserName(String managerUserName);

    @Modifying
    @Query("update Employee e set e.managerUserName = :manager_user_name where e.empUserName = :emp_user_name and e.empId = :emp_id")
    void updateEmployeeManager(@Param(value = "emp_id") long empId,
            @Param(value = "emp_user_name") String empUserName,
            @Param(value = "manager_user_name") String managerUserName);

}
