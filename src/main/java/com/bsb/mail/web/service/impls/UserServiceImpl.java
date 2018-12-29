package com.bsb.mail.web.service.impls;

import com.bsb.mail.common.ServerResponse;
import com.bsb.mail.model.Binding;
import com.bsb.mail.model.User;
import com.bsb.mail.web.dao.IBindRepository;
import com.bsb.mail.web.dao.IUserRepository;
import com.bsb.mail.web.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: zeng
 * @Date: 2018/10/24 20:26
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBindRepository bindRepository;

    @Override
    public Boolean register(String username, String password, String question, String answer) {

        password = passwordEncoder.encode(password);
        User user = new User(username, password, question, answer);
        userRepository.save(user);
        return true;
    }

    @Override
    public Boolean checkIfUserAlreadyBindThisEmail(String username, String emailAddress) {
        return bindRepository.checkIfUserAlreadyBindThisEmail(username, emailAddress) == 1;
    }

    @Override
    public ServerResponse<String> bind(String username, String emailAddress) {

        if (StringUtils.isNoneEmpty(username, emailAddress)) {
            return ServerResponse.createByErrorMsg("用户名或绑定邮箱为空");
        }

        Binding binding = new Binding();
        binding.setUsername(username);
        binding.setEmailAddress(emailAddress);
        bindRepository.save(binding);

        return ServerResponse.createBySuccessMsg("用户绑定邮箱成功");
    }

    @Override
    public ServerResponse<String> checkIfBind(String username) {

        if (!StringUtils.isEmpty(username)) {
            if (bindRepository.checkIfBind(username) == 1) {
                return ServerResponse.createBySuccessMsg("用户已有绑定邮箱");
            }
        }

        return ServerResponse.createByErrorMsg("用户未绑定邮箱");
    }
}
