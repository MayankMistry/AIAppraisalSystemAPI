package com.mscit.develop.AIAppraisalSystemAPI.exception;

import java.util.Date;

import lombok.Data;

@Data
public class Error {

    private Integer statusCode;
    private String message;
    private Date timeStamp;
}
