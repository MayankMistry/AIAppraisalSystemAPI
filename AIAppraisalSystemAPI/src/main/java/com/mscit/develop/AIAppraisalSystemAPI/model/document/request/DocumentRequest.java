package com.mscit.develop.AIAppraisalSystemAPI.model.document.request;

public record DocumentRequest(

                String firstName,
                String lastName,
                String effectiveDate,
                String financialYear,
                String grade) {
}
