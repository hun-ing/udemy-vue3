package com.udemy.vueapi.requests.repository;

import com.udemy.vueapi.requests.entity.RequestEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {


  List<RequestEntity> findAllByCoachId(Long coachId);
}
