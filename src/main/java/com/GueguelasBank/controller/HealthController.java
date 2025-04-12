package com.GueguelasBank.controller;


import com.GueguelasBank.contract.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements HealthApi {

    @Override
    public ResponseEntity<?> health() {
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

}
