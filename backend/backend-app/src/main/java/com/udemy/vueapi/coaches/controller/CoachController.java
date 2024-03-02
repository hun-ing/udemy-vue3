package com.udemy.vueapi.coaches.controller;

import com.udemy.vueapi.areas.entity.AreaEntity;
import com.udemy.vueapi.areas.repository.AreaRepository;
import com.udemy.vueapi.coaches.domain.CoachDomain;
import com.udemy.vueapi.coaches.dto.CoachDTO;
import com.udemy.vueapi.coaches.entity.CoachEntity;
import com.udemy.vueapi.coaches.repository.CoachRepository;
import com.udemy.vueapi.coachesareas.entity.CoachAreaEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoachController {

  private final CoachRepository coachRepository;
  private final AreaRepository areaRepository;

  @PutMapping("/api/coach")
  public ResponseEntity<CoachDTO> createCoach(@RequestBody CoachDTO requestBody) {

    CoachEntity coachEntity = CoachDomain.of(requestBody).toCreateEntity();

    requestBody.getAreas().forEach(areaDTO -> {
      Optional<AreaEntity> optionalArea = areaRepository.findByArea(areaDTO.getArea());
      if (optionalArea.isPresent()) {
        CoachAreaEntity coachArea = CoachAreaEntity.createCoachArea(optionalArea.get());
        coachEntity.addCoachArea(coachArea);
      }
    });

    coachRepository.save(coachEntity);

    return ResponseEntity.status(HttpStatus.OK).body(CoachDTO.toCreateDTO(coachEntity));
  }

  @GetMapping("/api/coaches")
  public ResponseEntity<List<CoachDTO>> getCoaches() {
    List<CoachEntity> surveyEntities = coachRepository.findAll();

    List<CoachDTO> coachDTOList = surveyEntities.stream()
      .map(CoachDTO::toCreateDTO)
      .toList();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(coachDTOList);
  }
}
