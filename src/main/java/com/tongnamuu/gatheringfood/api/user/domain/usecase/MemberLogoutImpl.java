package com.tongnamuu.gatheringfood.api.user.domain.usecase;

import com.tongnamuu.gatheringfood.api.user.domain.usecase.command.MemberLogout;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberLogoutImpl implements MemberLogout {

    @Override
    public void execute() {

    }
}
