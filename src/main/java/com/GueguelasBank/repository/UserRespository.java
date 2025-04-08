package com.GueguelasBank.repository;

import com.GueguelasBank.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<Users, Integer> {
}
