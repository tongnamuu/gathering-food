package com.tongnamuu.gatheringfood.api.user.domain.entity;

import static com.tongnamuu.gatheringfood.api.user.domain.validator.UserValidator.validateBirthday;
import static com.tongnamuu.gatheringfood.api.user.domain.validator.UserValidator.validateName;

import com.tongnamuu.gatheringfood.api.user.domain.util.PasswordEncoder;
import com.tongnamuu.gatheringfood.api.user.domain.validator.UserValidator;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String encodedPassword;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Group> groups = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Food> allergyFoodList = new LinkedHashSet<>();


    @Builder
    private Member(String name, String username, String encodedPassword, String birthday, Gender gender, String email,
                   List<Group> groups) {
        Objects.requireNonNull(groups);
        this.name = validateName(name);
        this.username = UserValidator.validateUsername(username);
        this.encodedPassword = encodedPassword;
        this.birthday = validateBirthday(birthday);
        this.gender = gender;
        this.email = email;
        this.groups.addAll(groups);
    }

    @Builder(builderMethodName = "participantsBuilder", buildMethodName = "participantsBuild")
    private Member(String name, String username, String encodedPassword, String birthday, Gender gender, String email,
                   List<Food> foods, String description) {
        Objects.requireNonNull(foods);
        this.name = validateName(name);
        this.username = username;
        this.encodedPassword = encodedPassword;
        this.birthday = validateBirthday(birthday);
        this.gender = gender;
        this.email = email;
        this.allergyFoodList.addAll(foods);
        this.description = description;
    }

    public Member login(PasswordEncoder passwordEncoder, String rawPassword) {
        if (!passwordEncoder.matches(encodedPassword, rawPassword)) {
            throw new IllegalArgumentException();
        }
        return this;
    }


    public List<String> getAuthorities() {
        return this.roles.stream().map(it -> it.getName()).toList();
    }
}
