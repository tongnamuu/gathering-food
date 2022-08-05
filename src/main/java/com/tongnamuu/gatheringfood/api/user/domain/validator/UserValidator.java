package com.tongnamuu.gatheringfood.api.user.domain.validator;

import java.util.Objects;

public class UserValidator {
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
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException();
        }
        return password;
    }

    public static String validateBirthday(String birthday) {
        if (birthday != null) {
            if (birthday.length() != 8) {
                throw new IllegalArgumentException();
            }
        }
        return birthday;
    }
}
