package com.bsb.mail.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: zeng
 * @Date: 2018/9/29 10:57
 */
@Controller
public class ResourceController {

    @GetMapping("/")
    public String form() {
        return "html/login";
    }

    @GetMapping("/main")
    public String main() {
        return "html/main";
    }

    @GetMapping("/bad/{code}")
    public String getBad(@PathVariable Integer code) {
        return "bad/" + String.valueOf(code);
    }


}
