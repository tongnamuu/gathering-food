package com.tongnamuu.gatheringfood.api.user.domain.entity;

import com.tongnamuu.gatheringfood.api.user.domain.util.PasswordEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String encodedPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @Override
    public Member login(PasswordEncoder passwordEncoder, String rawPassword) {
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
        return List.of("ROLE_MEMBER");
    }
}
