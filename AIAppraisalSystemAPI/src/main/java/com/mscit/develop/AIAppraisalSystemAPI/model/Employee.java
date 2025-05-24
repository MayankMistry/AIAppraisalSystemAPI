package com.mscit.develop.AIAppraisalSystemAPI.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "employee")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "empId")
        private Long empId;
        @Column(name = "password")
        private String password;
        @Column(name = "empUserName", unique = true, nullable = false)
        private String empUserName;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "email_id", unique = true, nullable = false)
        private String email;
        @Column(name = "mobile_no", unique = true, nullable = false)
        private String mobileno;
        @Column(name = "role", columnDefinition = "ENUM('EMPLOYEE', 'MANAGER')")
        private String role;
        @Column(name = "employeeStartDate")
        private String employeeStartDate;
        @Column(name = "gender", columnDefinition = "ENUM('MALE', 'FEMALE')")
        private String gender;
        @Column(name = "employeeDob")
        private String employeeDob;
        @Column(name = "employee_type")
        private String employeeType;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "fk_emp_id", referencedColumnName = "empId")
        private List<Address> addressList;
}
