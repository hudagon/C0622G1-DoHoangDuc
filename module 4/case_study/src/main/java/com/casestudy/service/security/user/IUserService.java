package com.casestudy.service.security.user;

import com.casestudy.model.security.User;
import com.casestudy.service.IGeneralService;

public interface IUserService extends IGeneralService<User> {

    User findUserByUsername(String username);

}
