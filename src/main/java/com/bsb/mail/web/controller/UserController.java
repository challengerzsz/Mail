package com.bsb.mail.web.controller;

import com.bsb.mail.common.SecurityConstants;
import com.bsb.mail.pojo.User;
import com.bsb.mail.web.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zeng
 * @Date: 2018/10/24 12:46
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private IUserService userService;

    @PostMapping("/dev/login")
    public ModelAndView login(ModelAndView modelAndView, @RequestParam String username, @RequestParam String password) {

        if (StringUtils.isNoneBlank(username, password)) {
            logger.info("username {}, password {}", username, password);
            User user = userService.login(username, password);
            if (user != null) {
                modelAndView.addObject("user", user);
            }
        }
        return null;
    }

    @PostMapping("/register")
    public void register(HttpServletRequest request,
                           HttpServletResponse response,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String question,
                           @RequestParam String answer) throws IOException {
        if (StringUtils.isNoneBlank(username, password, question, answer)) {
            Boolean result = userService.register(username, password, question, answer);
            if (result) {
//                modelAndView.setViewName(SecurityConstants.LOGIN_PAGE);
            } else {
//                modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        redirectStrategy.sendRedirect(request, response, "/");
    }
}
