package com.bsb.works.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zeng
 * @Date: 2018/9/29 10:57
 */
@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "html/main";
    }

    @GetMapping("/test")
    public String test() {
        return "html/test";
    }

    @GetMapping("/form")
    public String form() {
        return "html/form";
    }
}
