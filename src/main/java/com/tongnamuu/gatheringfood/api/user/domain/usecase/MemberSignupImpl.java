package com.tongnamuu.gatheringfood.api.user.domain.usecase;

import static com.tongnamuu.gatheringfood.api.user.domain.validator.UserValidator.validatePassword;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Member;
import com.tongnamuu.gatheringfood.api.user.domain.repository.FoodRepository;
import com.tongnamuu.gatheringfood.api.user.domain.repository.GroupRepository;
import com.tongnamuu.gatheringfood.api.user.domain.repository.MemberRepository;
import com.tongnamuu.gatheringfood.api.user.domain.repository.RoleRepository;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.command.MemberSignup;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.input.MemberSignupInput;
import com.tongnamuu.gatheringfood.api.user.domain.usecase.result.MemberSignupResult;
import com.tongnamuu.gatheringfood.api.user.domain.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSignupImpl implements MemberSignup {
    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final GroupRepository groupRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberSignupResult execute(MemberSignupInput input) {
        Member member = memberRepository.save(createMember(input));
        MemberSignupResult result = MemberSignupResult.from(member);
        log.info("Signup Result: " + result.toString());
        return result;
    }

    private Member createMember(MemberSignupInput input) {
        if (input.isParticipant()) {
            return Member.participantsBuilder()
                .username(input.getUsername())
                .name(input.getName())
                .encodedPassword(passwordEncoder.encode(validatePassword(input.getPassword())))
                .birthday(input.getBirthday())
                .gender(input.getGender())
                .email(input.getEmail())
                .foods(input.getAllergyFoodList().stream().map(foodRepository::findByName).toList())
                .description(input.getDescription())
                .participantsBuild()
                .addRole(roleRepository.findByName("participant"));
        }
        return Member.builder()
            .username(input.getUsername())
            .name(input.getName())
            .encodedPassword(passwordEncoder.encode(validatePassword(input.getPassword())))
            .birthday(input.getBirthday())
            .gender(input.getGender())
            .email(input.getEmail())
            .groups(input.getGroupNames().stream().map(groupRepository::findByName).toList())
            .build().addRole(roleRepository.findByName("organizer"));

    }
}
