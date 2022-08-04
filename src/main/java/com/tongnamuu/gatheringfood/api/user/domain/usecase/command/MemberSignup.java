package com.tongnamuu.gatheringfood.api.user.domain.usecase.command;

import com.tongnamuu.gatheringfood.api.user.domain.usecase.input.MemberSignupInput;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.MemberSignupResult;

public interface MemberSignup {
    MemberSignupResult execute(MemberSignupInput input);
}
