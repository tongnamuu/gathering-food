package com.tongnamuu.gatheringfood.api.user.domain.entity;

import com.tongnamuu.gatheringfood.api.user.domain.util.PasswordEncoder;
import java.util.List;

public interface User {
    long getId();
    User login(PasswordEncoder passwordEncoder, String rawPassword);
    void logout();
    List<String> getAuthorities();
}
