package com.udemy.vueapi.repositories;

import com.udemy.vueapi.entities.RequestEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {


  List<RequestEntity> findAllByCoachId(Long coachId);
}
