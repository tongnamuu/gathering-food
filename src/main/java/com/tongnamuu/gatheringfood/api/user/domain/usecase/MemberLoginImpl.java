package com.tongnamuu.gatheringfood.api.user.domain.usecase;


import com.tongnamuu.gatheringfood.api.user.domain.entity.Member;
import com.tongnamuu.gatheringfood.api.user.domain.exception.MemberNotFoundException;
import com.tongnamuu.gatheringfood.api.user.domain.exception.WrongPasswordException;
import com.tongnamuu.gatheringfood.api.user.domain.repository.MemberRepository;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.command.MemberLogin;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.input.MemberLoginInput;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.MemberLoginResult;
import com.tongnamuu.gatheringfood.api.user.domain.util.JwtTokenManager;
import com.tongnamuu.gatheringfood.api.user.domain.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberLoginImpl implements MemberLogin {
    private final MemberRepository memberRepository;
    private final JwtTokenManager jwtTokenManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberLoginResult execute(MemberLoginInput input) {
        Member member = memberRepository.findByUsername(input.getUsername());
        if (member == null) {
            throw new MemberNotFoundException();
        }
        if (!passwordEncoder.matches(input.getPassword(), member.getEncodedPassword())) {
            throw new WrongPasswordException();
        }
        String accessToken = jwtTokenManager.createAccessToken(member);
        String refreshToken = jwtTokenManager.createRefreshToken(member);
        return MemberLoginResult.builder()
                                .accessToken(accessToken)
                                .refreshToken(refreshToken)
                                .build();
    }
}
