package com.GueguelasBank.contract;


import com.GueguelasBank.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/users")
public interface UserApi {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<Object> getUsers();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Object> getUserById(@PathVariable Integer id);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<Object> saveUser(Users user);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Object> deleteUser(@PathVariable Integer id);

}
