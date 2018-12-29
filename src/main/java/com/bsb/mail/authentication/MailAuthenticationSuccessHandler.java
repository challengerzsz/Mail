package com.bsb.mail.authentication;

import com.bsb.mail.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user = (User) authentication.getPrincipal();

        logger.info("登录成功");
        logger.info("principal : {}  username : {} ", authentication.getPrincipal(), user.getUsername());

        session.setAttribute(Const.CURRENT_USER, user.getUsername());
        redirectStrategy.sendRedirect(request, response, "/main");
    }

}
