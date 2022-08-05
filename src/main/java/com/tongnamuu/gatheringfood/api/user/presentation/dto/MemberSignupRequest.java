package com.tongnamuu.gatheringfood.api.user.presentation.dto;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Gender;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.input.MemberSignupInput;
import java.util.Collection;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "password")
public class MemberSignupRequest {
    private String name;
    private String username;
    private String password;
    private String email;
    private String gender;
    private String birthday;
    private String description;
    private boolean isParticipant;
    private Collection<String> allergyFoodList;
    private Collection<String> groupNames;

    public MemberSignupInput toInput() {
        return MemberSignupInput.builder()
            .name(name)
            .username(username)
            .password(password)
            .email(email)
            .gender(Gender.getGenderFromName(gender))
            .birthday(birthday)
            .description(description)
            .isParticipant(isParticipant)
            .allergyFoodList(allergyFoodList)
            .groupNames(groupNames)
            .build();
    }
}
