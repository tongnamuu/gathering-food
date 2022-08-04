package com.tongnamuu.gatheringfood.api.user.domain.util;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String password, String rawPassword);
}
