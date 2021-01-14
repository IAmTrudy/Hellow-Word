package com.lxp.hello.sys.service.impl;

import com.lxp.hello.sys.bean.UserBean;
import com.lxp.hello.sys.dao.UserDao;
import com.lxp.hello.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserBean findUserByUserNameAndPassword(UserBean userBean) {
        UserBean userBean1 = userDao.findUserByUserNameAndPassword(userBean);
        return userBean1;
    }

    @Override
    public UserBean findUserByUserName(UserBean userBean) {
        UserBean userBean1 = userDao.findUserByUserName(userBean);
        return userBean1;
    }

    @Override
    public void saveUser(UserBean userBean) {
        userDao.save(userBean);
    }
}
