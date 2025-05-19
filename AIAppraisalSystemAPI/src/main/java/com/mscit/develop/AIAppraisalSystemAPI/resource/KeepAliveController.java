package com.mscit.develop.AIAppraisalSystemAPI.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-appraisal-system")
public class KeepAliveController {

    @GetMapping("/keep-alive")
    public String keepAliveCheck() {
         return "Keep Alive";
    }

}
