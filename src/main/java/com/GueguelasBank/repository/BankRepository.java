package com.GueguelasBank.repository;

import com.GueguelasBank.model.Banks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Banks, Integer> {
}
