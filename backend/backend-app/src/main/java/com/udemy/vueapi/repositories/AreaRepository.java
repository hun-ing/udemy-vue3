package com.udemy.vueapi.repositories;

import com.udemy.vueapi.entities.AreaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {

  Optional<AreaEntity> findByArea(String area);
}
