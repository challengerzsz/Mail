package com.bsb.mail;

import com.bsb.mail.model.User;
import com.bsb.mail.web.dao.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorksApplicationTests {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertNewUser() {
        userRepository.save(new User(1, "zsz", passwordEncoder.encode("123456"),
                "生日", "980305"));
    }
}
