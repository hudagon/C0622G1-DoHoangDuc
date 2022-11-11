package com.casestudy.repository;

import com.casestudy.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);

}
