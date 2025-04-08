package com.GueguelasBank.controller;


import com.GueguelasBank.contract.UserApi;
import com.GueguelasBank.model.Users;
import com.GueguelasBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> response = this.userService.getUser();
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
