package com.udemy.vueapi.coaches.repository;

import com.udemy.vueapi.coaches.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<CoachEntity, Long> {

}
