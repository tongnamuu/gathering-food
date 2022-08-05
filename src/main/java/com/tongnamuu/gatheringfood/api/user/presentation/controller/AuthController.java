package com.tongnamuu.gatheringfood.api.user.presentation.controller;

import com.tongnamuu.gatheringfood.api.user.domain.usecase.command.MemberLogin;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.command.MemberLogout;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.command.MemberSignup;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.MemberLoginResult;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.MemberSignupResult;
import com.tongnamuu.gatheringfood.api.user.presentation.dto.MemberLoginRequest;
import com.tongnamuu.gatheringfood.api.user.presentation.dto.MemberLoginResponse;
import com.tongnamuu.gatheringfood.api.user.presentation.dto.MemberLogoutResponse;
import com.tongnamuu.gatheringfood.api.user.presentation.dto.MemberSignupRequest;
import com.tongnamuu.gatheringfood.api.user.presentation.dto.MemberSignupResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final MemberLogin memberLogin;
    private final MemberLogout memberLogout;
    private final MemberSignup memberSignup;

    @PostMapping("login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest request) {
        log.info("LoginRequest: " + request.toString());
        MemberLoginResult result = memberLogin.execute(request.toInput());
        MemberLoginResponse response = MemberLoginResponse.from(result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("signup")
    public ResponseEntity<MemberSignupResponse> signup(@RequestBody MemberSignupRequest request) {
        log.info("Signup Request : " + request.toString());
        MemberSignupResult result = memberSignup.execute(request.toInput());
        MemberSignupResponse response = MemberSignupResponse.from(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("logout")
    public ResponseEntity<MemberLogoutResponse> logout() {
        memberLogout.execute();
        MemberLogoutResponse response = new MemberLogoutResponse();
        return ResponseEntity.ok().body(response);
    }
}
