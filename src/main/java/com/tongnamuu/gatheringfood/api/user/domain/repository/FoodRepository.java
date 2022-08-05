package com.tongnamuu.gatheringfood.api.user.domain.repository;

import com.tongnamuu.gatheringfood.api.user.domain.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String name);
}
