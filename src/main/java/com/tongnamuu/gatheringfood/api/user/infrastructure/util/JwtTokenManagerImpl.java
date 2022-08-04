package com.tongnamuu.gatheringfood.api.user.infrastructure.util;

import com.tongnamuu.gatheringfood.api.user.domain.entity.User;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.JwtDecodeResult;
import com.tongnamuu.gatheringfood.api.user.domain.util.JwtTokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class JwtTokenManagerImpl implements JwtTokenManager {

    private static final String SECRET_KEY = "wefaxzcvfefaefaefaefaeeaseefefefafefewsfawsefefefasefasefasefasefasefawsefaxzcbvfdshbtdjndfynsdtaesfawefawefqwerasdvadfaesfeaswfaefawsef";
    private static final int ACCESS_TOKEN_DURATION = 300;
    private static final int REFRESH_TOKEN_DURATION = 7200;

    @Override
    public String createAccessToken(User user) {
        Date expireDate = Date.from(Instant.now().plusSeconds(ACCESS_TOKEN_DURATION));
        return createJwtToken(user, expireDate);
    }

    @Override
    public String createRefreshToken(User user) {
        Date expireDate = Date.from(Instant.now().plusSeconds(REFRESH_TOKEN_DURATION));
        return createJwtToken(user, expireDate);
    }

    @Override
    public JwtDecodeResult decodeJwtToken(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJwt(token)
            .getBody();
        Long memberId = Long.parseLong(claims.getSubject());
        return JwtDecodeResult.builder()
            .memberId(memberId)
            .build();
    }

    private String createJwtToken(User user, Date expireDate) {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .setSubject(user.getId().toString())
            .setIssuedAt(new Date())
            .setExpiration(expireDate)
            .compact();
    }
}
