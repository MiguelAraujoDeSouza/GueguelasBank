package com.GueguelasBank.controller;

import com.GueguelasBank.contract.BankApi;
import com.GueguelasBank.dto.Message;
import com.GueguelasBank.error.Errors;
import com.GueguelasBank.model.Banks;
import com.GueguelasBank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController implements BankApi {

    @Autowired
    private BankService bankService;

    @Override
    public ResponseEntity<Object> getBanks() {
        List<Banks> response = this.bankService.getBanks();
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
    public ResponseEntity<Object> getBankById(int id) {
        if(id <= 0) {
            Message message = new Message(
                    Errors.MORE_THEN_ZERO.getCode(),
                    Errors.MORE_THEN_ZERO.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        Banks response = this.bankService.getBankById(id);
        if (response == null) {
            Message message = new Message(
                    Errors.BANK_NOT_FOUND.getCode(),
                    Errors.BANK_NOT_FOUND.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> saveBank(Banks bank) {
        Banks response = this.bankService.saveBank(bank);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> deleteBank(int id) {
        if(id <= 0) {
            Message message = new Message(
                    Errors.MORE_THEN_ZERO.getCode(),
                    Errors.MORE_THEN_ZERO.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        if (this.bankService.getBankById(id) == null) {
            Message message = new Message(
                    Errors.BANK_NOT_FOUND.getCode(),
                    Errors.BANK_NOT_FOUND.getMessage()
            );
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        this.bankService.deleteBank(id);
        Message message = new Message(
                200,
                "Bank deleted successfully"
        );
        return ResponseEntity.ok(message);
    }

}
