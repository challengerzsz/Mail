package com.bsb.mail.web.service.impls;

import com.bsb.mail.model.Mail;
import com.bsb.mail.web.dao.IMailRepository;
import com.bsb.mail.web.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private IMailRepository mailRepository;

    @Override
    public boolean send(String from, String to, String text, boolean hasAttach, List<MultipartFile> files) {

        if (hasAttach) {
            // 文件上传
        }
        Mail mail = new Mail(from, to, text, 0L, null);
        mailRepository.save(mail);
        return true;
    }
}
