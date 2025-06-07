package com.mscit.develop.AIAppraisalSystemAPI.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscit.develop.AIAppraisalSystemAPI.domain.service.DocumentServiceImpl;
import com.mscit.develop.AIAppraisalSystemAPI.model.document.request.DocumentRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/employee-appraisal-system")
public class DocumentController {

    @Autowired
    private DocumentServiceImpl documentServiceImpl;

    @PostMapping("/generate-letter")
    public void generateLetter(@RequestBody DocumentRequest documenetRequest, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        documentServiceImpl.generateLetter(documenetRequest, httpServletRequest, httpServletResponse);
    }

}
