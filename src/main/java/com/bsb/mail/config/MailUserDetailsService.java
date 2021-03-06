package com.bsb.mail.config;

import com.bsb.mail.web.dao.IUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author: zeng
 * @Date: 2018/10/24 20:56
 */
@Component
public class MailUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        if (!StringUtils.isEmpty(username)) {
            String password = userRepository.getPassword(username);
            if (password == null) {
                throw new UsernameNotFoundException(username);
            }
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDetails = new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
        }

        return userDetails;
    }

}
