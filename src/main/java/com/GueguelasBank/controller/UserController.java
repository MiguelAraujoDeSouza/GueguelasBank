package com.GueguelasBank.controller;


import com.GueguelasBank.contract.UserApi;
import com.GueguelasBank.dto.Message;
import com.GueguelasBank.error.Errors;
import com.GueguelasBank.model.Users;
import com.GueguelasBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Object> getUsers() {
        List<Users> response = this.userService.getUser();
        if (response.isEmpty()) {
            Message message = new Message(
                    Errors.EMPTY_REGISTERS.getCode(),
                    Errors.EMPTY_REGISTERS.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);

    }
}
