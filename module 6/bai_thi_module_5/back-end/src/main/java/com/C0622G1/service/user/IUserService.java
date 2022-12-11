package com.C0622G1.service.user;

import com.C0622G1.model.User;
import com.C0622G1.service.IGeneralService;

public interface IUserService extends IGeneralService<User> {

    User findByUserName(String userName);

}
