package com.tongnamuu.gatheringfood.api.user.domain.repository;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
