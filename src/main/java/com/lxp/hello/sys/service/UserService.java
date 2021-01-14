package com.lxp.hello.sys.service;

import com.lxp.hello.sys.bean.UserBean;

public interface UserService {

    UserBean findUserByUserNameAndPassword(UserBean userBean);
    UserBean findUserByUserName(UserBean userBean);
    void saveUser(UserBean userBean);
}
