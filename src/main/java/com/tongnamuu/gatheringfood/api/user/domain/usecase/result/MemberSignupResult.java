package com.tongnamuu.gatheringfood.api.user.domain.usecase.result;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Member;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberSignupResult {
    private ZonedDateTime signupAt;
    private String username;
    private String name;

    @Builder(access = AccessLevel.PRIVATE)
    private MemberSignupResult(ZonedDateTime signupAt, String username, String name) {
        this.signupAt = signupAt;
        this.username = username;
        this.name = name;
    }

    public static MemberSignupResult from(Member member) {
        return MemberSignupResult.builder()
                                 .signupAt(ZonedDateTime.now())
                                 .username(member.getUsername())
                                 .name(member.getName())
                                 .build();
    }
}
