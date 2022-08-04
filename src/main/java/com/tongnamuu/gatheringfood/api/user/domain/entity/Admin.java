package com.tongnamuu.gatheringfood.api.user.domain.entity;

import com.tongnamuu.gatheringfood.api.user.domain.util.PasswordEncoder;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String encodedPassword;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_day", nullable = false)
    private String birthDay;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Builder
    private Admin(String name, String username, String encodedPassword, String email, String birthDay,
                 String gender) {
        this.name = name;
        this.username = username;
        this.encodedPassword = encodedPassword;
        this.email = email;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    @Override
    public Admin login(PasswordEncoder passwordEncoder, String rawPassword) {
        if(!passwordEncoder.matches(encodedPassword, rawPassword)) {
            throw new IllegalArgumentException();
        }
        return this;
    }

    @Override
    public void logout() {

    }

    @Override
    public List<String> getAuthorities() {
        return List.of("ROLE_ADMIN");
    }
}

