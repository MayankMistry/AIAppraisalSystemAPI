package com.mscit.develop.AIAppraisalSystemAPI.exception;

public class EmployeeNotFoundException  extends RuntimeException {

    private static final long serialVersionUID = 1;

    public EmployeeNotFoundException (String message) {
        super(message);
    }

}
