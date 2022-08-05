package com.tongnamuu.gatheringfood.api.user.domain.validator;

import java.util.Objects;

public class UserValidator {
    public static final String PASSWORD_REGEX = ".*[A-Z].*";
    public static final String YYYYMMDD = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])";

    public static String validateName(String name) {
        Objects.requireNonNull(name);
        if (name.length() == 0 || name.length() > 10) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    public static String validateUsername(String username) {
        Objects.requireNonNull(username);
        if (username.length() == 0 || username.length() > 200) {
            throw new IllegalArgumentException();
        }
        return username;
    }

    public static String validatePassword(String password) {
        Objects.requireNonNull(password);
        if (password.length() < 8) {
            throw new IllegalArgumentException();
        }
        if (!password.matches(PASSWORD_REGEX)) {
            throw new IllegalArgumentException();
        }
        return password;
    }

    public static String validateBirthday(String birthday) {
        if (birthday != null) {
            if (!birthday.matches(YYYYMMDD)) {
                throw new IllegalArgumentException();
            }
        }
        return birthday;
    }
}
