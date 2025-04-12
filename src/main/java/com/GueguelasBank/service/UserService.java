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

    public Users getUserById(int id) {
        return userRespository.findById(id).orElse(null);
    }

    public Users saveUser(Users user) {
        return userRespository.save(user);
    }

    public void deleteUser(int id) {
        userRespository.deleteById(id);
    }
}
