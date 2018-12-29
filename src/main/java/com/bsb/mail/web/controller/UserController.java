package com.bsb.mail.web.controller;

import com.bsb.mail.common.Const;
import com.bsb.mail.common.SecurityConstants;
import com.bsb.mail.common.ServerResponse;
import com.bsb.mail.common.util.RegexUtil;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private RegexUtil regexUtil;

    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, @RequestParam String username,
                                 @RequestParam String password, @RequestParam() String confirmPassword,
                                 @RequestParam String question, @RequestParam String answer) {

        if (StringUtils.isNoneBlank(username, password, confirmPassword, question, answer)) {

            if (!password.equals(confirmPassword)) {
                modelAndView.addObject("message", "确认密码与密码不一致");
            }

            Boolean result = userService.register(username, password, question, answer);
            if (result) {
                modelAndView.setViewName("redirect:" + SecurityConstants.LOGIN_PAGE);
            } else {
                modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return modelAndView;
    }

    @PostMapping("/binding")
    @ResponseBody
    public ServerResponse<String> binding(HttpServletRequest request, @RequestParam("emailAddress") String emailAddress,
                                          @RequestParam("emailPassword") String emailPassword) {

        if (StringUtils.isNoneEmpty(emailAddress, emailAddress)) {
            return ServerResponse.createByErrorMsg("绑定邮箱地址或密码为空");
        }
        String username = (String) request.getSession().getAttribute(Const.CURRENT_USER);
        if (!userService.checkIfUserAlreadyBindThisEmail(username, emailAddress)
                && regexUtil.checkIfEmailCorrect(emailAddress)) {

            return userService.bind(username, emailAddress);
        }

        return ServerResponse.createBySuccessMsg("绑定邮箱失败");
    }

    @PostMapping("/checkIfBind")
    @ResponseBody
    public ServerResponse<String> checkIfBind(HttpSession session) {

        String username = (String) session.getAttribute(Const.CURRENT_USER);
        if (username == null) {
            return ServerResponse.createByErrorMsg("身份信息已失效");
        }

        return userService.checkIfBind(username);
    }
}
