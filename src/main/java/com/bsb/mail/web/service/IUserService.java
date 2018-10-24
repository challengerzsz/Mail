package com.bsb.mail.web.service;

import com.bsb.mail.pojo.User;

/**
 * @Author: zeng
 * @Date: 2018/10/24 20:23
 */
public interface IUserService {

    User login(String username, String password);

    Boolean register(String username, String password, String question, String answer);
}
