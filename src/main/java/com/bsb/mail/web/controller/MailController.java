package com.bsb.mail.web.controller;

import com.bsb.mail.web.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MailController {

    @Autowired
    private IMailService mailService;

    @RequestMapping("/mail/send")
    public String send(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to,
                       @RequestParam(value = "text") String text, @RequestParam(value = "hasAttach") boolean hasAttach,
                       List<MultipartFile> files) {
        if (mailService.send(from, to, text, hasAttach, files)) {

        }
        return null;
    }
}
