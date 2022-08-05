package com.tongnamuu.gatheringfood.api.user.presentation.dto;

import com.tongnamuu.gatheringfood.api.user.domain.usecase.input.MemberLoginInput;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString(exclude = "password")
@RequiredArgsConstructor
public class MemberLoginRequest {
    private final String username;
    private final String password;


    public MemberLoginInput toInput() {
        return MemberLoginInput.builder().username(this.username).password(this.password).build();
    }
}
