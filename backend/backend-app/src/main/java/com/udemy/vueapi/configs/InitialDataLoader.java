package com.udemy.vueapi.configs;

import com.udemy.vueapi.areas.domain.AreaDomain;
import com.udemy.vueapi.areas.dto.AreaDTO;
import com.udemy.vueapi.areas.entity.AreaEntity;
import com.udemy.vueapi.areas.repository.AreaRepository;
import com.udemy.vueapi.coaches.domain.CoachDomain;
import com.udemy.vueapi.coaches.dto.CoachDTO;
import com.udemy.vueapi.coaches.entity.CoachEntity;
import com.udemy.vueapi.coaches.repository.CoachRepository;
import com.udemy.vueapi.coachesareas.entity.CoachAreaEntity;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitialDataLoader {

  private final AreaRepository areaRepository;
  private final CoachRepository coachRepository;

  @PostConstruct
  public void init() {

    initAreas();
    initCoaches();
  }

  private void initCoaches() {
    AreaDTO frontend = AreaDTO.builder().area("frontend").build();
    AreaDTO backend = AreaDTO.builder().area("backend").build();
    AreaDTO career = AreaDTO.builder().area("career").build();

    List<AreaDTO> areas1 = new ArrayList<>();

    areas1.add(frontend);
    areas1.add(backend);
    areas1.add(career);

    List<AreaDTO> areas2 = new ArrayList<>();

    areas2.add(frontend);
    areas2.add(backend);

    List<AreaDTO> areas3 = new ArrayList<>();

    areas3.add(career);

    CoachDTO coach1 = CoachDTO.builder().firstName("test1").lastName("test1").hourlyRate(123)
        .description("test1!!").areas(areas1).build();
    CoachDTO coach2 = CoachDTO.builder().firstName("test2").lastName("test2").hourlyRate(124)
        .description("test2!!").areas(areas2).build();
    CoachDTO coach3 = CoachDTO.builder().firstName("test3").lastName("test3").hourlyRate(125)
        .description("test3!!").areas(areas3).build();

    CoachEntity coachEntity1 = CoachDomain.of(coach1).toCreateEntity();
    CoachEntity coachEntity2 = CoachDomain.of(coach2).toCreateEntity();
    CoachEntity coachEntity3 = CoachDomain.of(coach3).toCreateEntity();

    areas1.forEach(areaDTO -> {
      Optional<AreaEntity> optionalArea = areaRepository.findByArea(areaDTO.getArea());
      if (optionalArea.isPresent()) {
        CoachAreaEntity coachArea = CoachAreaEntity.createCoachArea(optionalArea.get());
        coachEntity1.addCoachArea(coachArea);
      }
    });

    areas2.forEach(areaDTO -> {
      Optional<AreaEntity> optionalArea = areaRepository.findByArea(areaDTO.getArea());
      if (optionalArea.isPresent()) {
        CoachAreaEntity coachArea = CoachAreaEntity.createCoachArea(optionalArea.get());
        coachEntity2.addCoachArea(coachArea);
      }
    });

    areas3.forEach(areaDTO -> {
      Optional<AreaEntity> optionalArea = areaRepository.findByArea(areaDTO.getArea());
      if (optionalArea.isPresent()) {
        CoachAreaEntity coachArea = CoachAreaEntity.createCoachArea(optionalArea.get());
        coachEntity3.addCoachArea(coachArea);
      }
    });

    coachRepository.save(coachEntity1);
    coachRepository.save(coachEntity2);
    coachRepository.save(coachEntity3);
  }

  private void initAreas() {
    AreaDTO frontend = AreaDTO.builder().area("frontend").build();
    AreaDTO backend = AreaDTO.builder().area("backend").build();
    AreaDTO career = AreaDTO.builder().area("career").build();

    areaRepository.save(AreaDomain.of(frontend).toCreateEntity());
    areaRepository.save(AreaDomain.of(backend).toCreateEntity());
    areaRepository.save(AreaDomain.of(career).toCreateEntity());
  }
}
