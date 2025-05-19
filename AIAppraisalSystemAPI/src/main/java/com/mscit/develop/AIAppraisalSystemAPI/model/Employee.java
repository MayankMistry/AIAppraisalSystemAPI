package com.mscit.develop.AIAppraisalSystemAPI.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long empId;
        @Column(name = "password")
        private String password;
        @Column(name = "empUserName")
        private String empUserName;
        // @Column(name = "first_name")
        // private String firstName;
        // @Column(name = "last_name")
        // private String lastName;
        // @Column(name = "email_id")
        // private String email;
        // @Column(name = "mobile_no")
        // private String mobileno;
}
