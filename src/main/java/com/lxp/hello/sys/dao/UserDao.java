package com.lxp.hello.sys.dao;

import com.lxp.hello.sys.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<UserBean, Integer> {

    @Query("select t1 from UserBean t1 where t1.userName = :#{#userBean.userName} and t1.password = :#{#userBean.password}")
    UserBean findUserByUserNameAndPassword(@Param("userBean") UserBean userBean);

    @Query("select t1 from UserBean t1 where t1.userName = :#{#userBean.userName}")
    UserBean findUserByUserName(@Param("userBean") UserBean userBean);
}
