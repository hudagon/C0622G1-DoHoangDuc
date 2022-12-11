package com.example.demo.service.account;

import com.example.demo.model.Account;

public interface IAccountService {

    Account findAccountByUsername(String username);

}
