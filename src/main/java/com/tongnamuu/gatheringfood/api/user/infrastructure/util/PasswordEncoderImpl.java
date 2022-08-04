package com.tongnamuu.gatheringfood.api.user.infrastructure.util;

import com.tongnamuu.gatheringfood.api.user.domain.util.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {
    private static final org.springframework.security.crypto.password.PasswordEncoder bCryptPasswordEncoder
        = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean matches(String password, String rawPassword) {
        return bCryptPasswordEncoder.matches(password, rawPassword);
    }
}
