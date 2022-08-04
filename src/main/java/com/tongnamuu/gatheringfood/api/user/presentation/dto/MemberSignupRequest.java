package com.tongnamuu.gatheringfood.api.user.presentation.dto;

import com.tongnamuu.gatheringfood.api.user.domain.usecase.input.MemberSignupInput;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "password")
public class MemberSignupRequest {
    private String username;
    private String name;
    private String password;

    public MemberSignupInput toInput() {
        return MemberSignupInput.builder()
                                .name(name)
                                .username(username)
                                .password(password)
                                .build();
    }
}
