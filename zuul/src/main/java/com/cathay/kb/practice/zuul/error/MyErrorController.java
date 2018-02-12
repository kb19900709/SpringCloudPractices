package com.cathay.kb.practice.zuul.error;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyErrorController implements ErrorController {

    @Value("${error.path:/error}")
    private String errorPath;

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @RequestMapping(value = "${error.path:/error}")
    public ResponseEntity error(HttpServletRequest request) {
        final int status = getErrorStatus(request);
        final String errorMessage = getErrorMessage(request);
        Map<String, String> error = getErrorBody(status, errorMessage);
        return ResponseEntity.status(status).body(error);
    }

    private Map<String, String> getErrorBody(int status, String errorMessage) {
        Map<String, String> error = new HashMap<>();
        error.put("message", errorMessage);
        error.put("status", Integer.toString(status));
        return error;
    }

    private int getErrorStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return statusCode != null ? statusCode : HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    private String getErrorMessage(HttpServletRequest request) {
        final Throwable exc = (Throwable) request.getAttribute("javax.servlet.error.exception");
        return exc != null ? exc.getMessage() : "Unexpected error occurred";
    }
}
