package com.tongnamuu.gatheringfood.api.user.domain.repository;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
