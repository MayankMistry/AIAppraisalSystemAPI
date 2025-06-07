package com.mscit.develop.AIAppraisalSystemAPI.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeRes {

    private Long empId;
    private String password;
    private String empUserName;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileno;
    private String role;
    private String employeeStartDate;
    private String gender;
    private String employeeDob;
    private String employeeType;
    private String managerUserName;

}
