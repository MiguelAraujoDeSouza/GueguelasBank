package com.GueguelasBank.service;

import com.GueguelasBank.model.Users;
import com.GueguelasBank.repository.UserRespository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Data
@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<Users> getUser() {
        return userRespository.findAll();
    }
}
