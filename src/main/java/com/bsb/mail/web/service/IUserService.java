package com.bsb.mail.web.service;

import com.bsb.mail.common.ServerResponse;
import com.bsb.mail.model.User;

/**
 * @Author: zeng
 * @Date: 2018/10/24 20:23
 */
public interface IUserService {

    Boolean register(String username, String password, String question, String answer);

    Boolean checkIfUserAlreadyBindThisEmail(String username, String emailAddress);

    ServerResponse<String> bind(String username, String emailAddress);

    ServerResponse<String> checkIfBind(String username);
}
