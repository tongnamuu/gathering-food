package com.tongnamuu.gatheringfood.api.user.domain.util;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Member;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.JwtDecodeResult;

public interface JwtTokenManager {
    String createAccessToken(Member member);
    String createRefreshToken(Member member);
    JwtDecodeResult decodeJwtToken(String token);
}
