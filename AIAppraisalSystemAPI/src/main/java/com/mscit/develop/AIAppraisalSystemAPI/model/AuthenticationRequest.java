package com.mscit.develop.AIAppraisalSystemAPI.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}
