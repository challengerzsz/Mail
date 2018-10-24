package com.bsb.mail.web.jpa;

import com.bsb.mail.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

/**
 * @Author: zeng
 * @Date: 2018/10/24 21:01
 */
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user.password FROM User user WHERE user.username =:username")
    String getPassword(@Param("username") String username);

    @Query("SELECT user FROM User user WHERE user.username =:username AND user.password =:password")
    User login(@Param("username") String username, @Param("password") String password);
}
