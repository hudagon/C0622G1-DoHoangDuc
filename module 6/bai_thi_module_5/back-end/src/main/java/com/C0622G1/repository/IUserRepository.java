package com.C0622G1.repository;

import com.C0622G1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String userName);
}
