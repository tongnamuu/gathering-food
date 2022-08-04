package com.tongnamuu.gatheringfood.api.user.domain.usecase.command;

import com.tongnamuu.gatheringfood.api.user.domain.usecase.input.MemberLoginInput;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.MemberLoginResult;

public interface MemberLogin {
    MemberLoginResult execute(MemberLoginInput input);
}
