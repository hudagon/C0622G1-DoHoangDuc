package com.ss3.model.service;

import com.ss3.model.model.Login;
import com.ss3.model.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
