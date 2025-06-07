package com.mscit.develop.AIAppraisalSystemAPI.domain.service;

import java.io.StringReader;
import java.net.URI;
import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xml.sax.helpers.DefaultHandler;

import com.mscit.develop.AIAppraisalSystemAPI.model.document.request.DocumentRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentServiceImpl {

    @Autowired
    private TemplateEngine templateEngine;

    public void generateLetter(DocumentRequest documenetRequest, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=appraisalLetter.pdf");
        httpServletResponse.setContentType(org.springframework.http.MediaType.APPLICATION_PDF_VALUE);
        Context context = new Context();
        context.setVariable("EFFECTIVEDATE", documenetRequest.effectiveDate());
        context.setVariable("FIRSTNAME", documenetRequest.firstName());
        context.setVariable("LASTNAME", documenetRequest.lastName());
        context.setVariable("FINANCIALYEAR", documenetRequest.financialYear());
        context.setVariable("GRADE", documenetRequest.grade());
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".fo");
        templateResolver.setCharacterEncoding("UTF-8");
        templateEngine.setTemplateResolver(templateResolver);
        String xmlTemplate = templateEngine.process("generate-letter", context);
        generate(xmlTemplate, httpServletResponse);
    }

    public void generate(String xmlTemplate, HttpServletResponse httpServletResponse) {

        try {

            FopFactory factory = FopFactory.newInstance(new URI("./"));
            DefaultHandler defaultHandler = factory
                    .newFop(MimeConstants.MIME_PDF, httpServletResponse.getOutputStream())
                    .getDefaultHandler();
            Source src = new StreamSource(new StringReader(xmlTemplate));
            Result res = new SAXResult(defaultHandler);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            transformerFactory.newTransformer().transform(src, res);

        } catch (Exception e) {
            log.error("Exception occured at a time of PDF generation {}", e.getMessage());
        }
    }

}
