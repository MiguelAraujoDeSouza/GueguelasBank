package com.GueguelasBank.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface HealthApi {
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<?> health();
}
