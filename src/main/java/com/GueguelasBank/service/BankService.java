package com.GueguelasBank.service;

import com.GueguelasBank.model.Banks;
import com.GueguelasBank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public List<Banks> getBanks() {
        return bankRepository.findAll();
    }

    public Banks getBankById(int id) {
        return bankRepository.findById(id).orElse(null);
    }

    public Banks saveBank(Banks bank) {
        return bankRepository.save(bank);
    }

    public void deleteBank(int id) {
        bankRepository.deleteById(id);
    }
}
