package com.tongnamuu.gatheringfood.api.user.domain.usecase.input;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberLoginInput {
    private String username;
    private String password;

    @Builder
    private MemberLoginInput(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
