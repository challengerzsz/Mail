package com.bsb.mail.web.service.impls;

import com.bsb.mail.pojo.User;
import com.bsb.mail.web.jpa.IUserRepository;
import com.bsb.mail.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: zeng
 * @Date: 2018/10/24 20:26
 */
@Service
public class UserService implements IUserService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public Boolean register(String username, String password, String question, String answer) {

        password = passwordEncoder.encode(password);
        User user = new User(2, username, password, question, answer);
        userRepository.save(user);
        return true;
    }
}
