package com.dby.parking.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ErrorHandler implements ErrorController {

     @Autowired
    ErrorAttributes errorAttributes;

     @RequestMapping("/error")
    ApiErrors handlerError(WebRequest webRequest){
         Map<String, Object> attribute = errorAttributes.getErrorAttributes(webRequest,
                 ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE,
                         ErrorAttributeOptions.Include.BINDING_ERRORS));
         String message = (String) attribute.get("message");
         String path = (String) attribute.get("path");
         int status = (Integer) attribute.get("status");
         ApiErrors apiErrors = new ApiErrors(status, message, new Date().getTime(), path);
         if (attribute.containsKey("errors")){
             List<FieldError> fieldErrors = (List<FieldError>) attribute.get("errors");
             Map<String, String> validator = new HashMap<>();
             for (FieldError fieldError : fieldErrors){
                 validator.put(fieldError.getField(), fieldError.getDefaultMessage());
             }
             apiErrors.setValidationErrors(validator);
         }
         return apiErrors;
     }

}
