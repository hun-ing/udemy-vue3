package com.udemy.vueapi.repositories;

import com.udemy.vueapi.entities.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<CoachEntity, Long> {

}
