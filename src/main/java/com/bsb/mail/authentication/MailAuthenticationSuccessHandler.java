package com.bsb.mail.authentication;

import com.bsb.mail.common.Const;
import com.bsb.mail.web.dao.IUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: zeng
 * @Date: 2018/10/24 21:37
 */
@Component
public class MailAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private IUserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user = (User) authentication.getPrincipal();

        logger.info("登录成功");
        logger.info("principal : {}  username : {} ", authentication.getPrincipal(), user.getUsername());

        String userImage = userRepository.getUserImage(user.getUsername());
        if (StringUtils.isEmpty(userImage)) {
            userImage = Const.DEFAULT_USER_IMAGE;
        }
        session.setAttribute(Const.CURRENT_USER, user.getUsername());
        session.setAttribute(Const.CURRENT_USER_IMAGE, userImage);
        redirectStrategy.sendRedirect(request, response, "/main");
    }

}
