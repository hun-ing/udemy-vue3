package com.udemy.vueapi.areas.repository;

import com.udemy.vueapi.areas.entity.AreaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {

  Optional<AreaEntity> findByArea(String area);
}
