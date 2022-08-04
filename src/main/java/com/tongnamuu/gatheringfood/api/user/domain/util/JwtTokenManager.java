package com.tongnamuu.gatheringfood.api.user.domain.util;

import com.tongnamuu.gatheringfood.api.user.domain.entity.User;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.JwtDecodeResult;

public interface JwtTokenManager {
    String createAccessToken(User user);
    String createRefreshToken(User user);
    JwtDecodeResult decodeJwtToken(String token);
}
