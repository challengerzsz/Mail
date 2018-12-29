package com.bsb.mail.web.service;

import com.bsb.mail.common.ServerResponse;
import com.bsb.mail.model.User;

/**
 * @Author: zeng
 * @Date: 2018/10/24 20:23
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    Boolean register(String username, String password, String question, String answer);

    boolean checkIfUserAlreadyBindThisEmail(String username, String emailAddress);

    ServerResponse<String> bind(String username, String emailAddress);
}
