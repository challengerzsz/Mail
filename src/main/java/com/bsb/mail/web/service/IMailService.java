package com.bsb.mail.web.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IMailService {

    boolean send(String from, String to, String text, boolean hasAttach, List<MultipartFile> file);
}
