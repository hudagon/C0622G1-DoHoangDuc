package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Query(
            value = " select * from account where username = :username ",
            nativeQuery = true
    )
    Account findAccountByUsername(@Param("username") String username);

}
