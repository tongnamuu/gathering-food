package com.tongnamuu.gatheringfood.api.user.domain.usecase.input;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSignupInput {
    private String username;
    private String name;
    private String password;

    @Builder
    private MemberSignupInput(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }
}
