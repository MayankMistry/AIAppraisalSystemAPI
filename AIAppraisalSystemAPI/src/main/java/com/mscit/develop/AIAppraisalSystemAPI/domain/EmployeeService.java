package com.mscit.develop.AIAppraisalSystemAPI.domain;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mscit.develop.AIAppraisalSystemAPI.model.Employee;

@Repository
public interface EmployeeService extends JpaRepository<Employee, Long> {

    // Optional<Employee> findbyUserName(String empUserName);

}
