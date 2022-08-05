package com.tongnamuu.gatheringfood.api.user.domain.entity;

public enum Gender {
    UNKNOWN,
    MALE,
    FEMALE,
    OTHER;

    public static Gender getGenderFromName(String name) {
        for (Gender g : Gender.values()) {
            if (g.name().equalsIgnoreCase(name)) {
                return g;
            }
        }
        return UNKNOWN;
    }
}
