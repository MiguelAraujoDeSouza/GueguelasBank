package com.GueguelasBank.contract;

import com.GueguelasBank.model.Banks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/banks")
public interface BankApi {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<Object> getBanks();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Object> getBankById(@PathVariable int id);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<Object> saveBank(Banks bank);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Object> deleteBank(@PathVariable int id);
}
