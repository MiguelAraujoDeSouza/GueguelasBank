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
    @Override
    public ResponseEntity<Object> getUserById(Integer id) {

        if(id <= 0) {
            Message message = new Message(
                    Errors.MORE_THEN_ZERO.getCode(),
                    Errors.MORE_THEN_ZERO.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        Users response = this.userService.getUserById(id);
        if (response == null) {
            Message message = new Message(
                    Errors.USER_NOT_FOUND.getCode(),
                    Errors.USER_NOT_FOUND.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> saveUser(Users user) {
        Users response = this.userService.saveUser(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> deleteUser(Integer id) {
        if(id <= 0) {
            Message message = new Message(
                    Errors.MORE_THEN_ZERO.getCode(),
                    Errors.MORE_THEN_ZERO.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        if (this.userService.getUserById(id) == null) {
            Message message = new Message(
                    Errors.USER_NOT_FOUND.getCode(),
                    Errors.USER_NOT_FOUND.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        this.userService.deleteUser(id);
        Message message = new Message(
                200,
                "User deleted successfully"
        );

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
