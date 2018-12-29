package com.bsb.mail.common.util;

import com.bsb.mail.common.Const;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @Author: zeng
 * @Date: 2018-12-29
 */
@Component
public class RegexUtil {

    public boolean checkIfEmailCorrect(String emailAddress) {
        return Pattern.matches(Const.EMAIL_REGEX, emailAddress);
    }
}
