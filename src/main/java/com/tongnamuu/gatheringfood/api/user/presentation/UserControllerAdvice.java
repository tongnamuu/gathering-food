package com.tongnamuu.gatheringfood.api.user.presentation;

import com.tongnamuu.gatheringfood.api.user.domain.exception.MemberNotFoundException;
import com.tongnamuu.gatheringfood.api.user.domain.exception.WrongPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(1)
public class UserControllerAdvice {
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<String> onMemberNotFoundException(MemberNotFoundException e) {
        log.error(e.getMessage(), e);
        System.out.println("hello#################");
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<String> onMemberNotFoundException(WrongPasswordException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().build();
    }
}
