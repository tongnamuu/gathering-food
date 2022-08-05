package com.tongnamuu.gatheringfood.api.user.domain.usecase.input;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Gender;
import java.util.Collection;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSignupInput {
    private final String name;
    private final String username;
    private final String password;
    private final String email;
    private final Gender gender;
    private final String birthday;
    private final String description;
    private final boolean isParticipant;
    private final Collection<String> allergyFoodList;
    private final Collection<String> groupNames;


    @Builder
    private MemberSignupInput(String name, String username, String password, String email,
                             Gender gender, String birthday, String description, boolean isParticipant,
                             Collection<String> allergyFoodList, Collection<String> groupNames) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.description = description;
        this.isParticipant = isParticipant;
        this.allergyFoodList = allergyFoodList == null ? List.of() : allergyFoodList;
        this.groupNames = groupNames == null ? List.of() : groupNames;
    }
}
