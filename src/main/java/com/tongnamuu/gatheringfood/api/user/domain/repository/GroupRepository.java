package com.tongnamuu.gatheringfood.api.user.domain.repository;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
