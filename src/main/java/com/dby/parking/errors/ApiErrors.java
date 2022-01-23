package com.dby.parking.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrors {

    int status;
    String message;
    Long timestamp;
    String path;

    Map<String, String> validationErrors;

    ApiErrors(int status, String message, long timestamp, String path){
        this.status = status;
        this.message = message;
        this.timestamp = new Date().getTime();
        this.path = path;
    }
}
