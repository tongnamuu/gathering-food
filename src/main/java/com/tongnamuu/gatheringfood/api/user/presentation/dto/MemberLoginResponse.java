package com.tongnamuu.gatheringfood.api.user.presentation.dto;

import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.MemberLoginResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberLoginResponse {
    private String accessToken;
    private String refreshToken;

    @Builder(access = AccessLevel.PRIVATE)
    private MemberLoginResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static MemberLoginResponse from(MemberLoginResult result) {
        return MemberLoginResponse.builder()
                                  .accessToken(result.getAccessToken())
                                  .refreshToken(result.getRefreshToken())
                                  .build();
    }
}
