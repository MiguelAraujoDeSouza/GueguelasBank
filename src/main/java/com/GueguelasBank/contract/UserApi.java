package com.GueguelasBank.contract;

import com.GueguelasBank.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface UserApi {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<List<Users>> getUsers();
}
