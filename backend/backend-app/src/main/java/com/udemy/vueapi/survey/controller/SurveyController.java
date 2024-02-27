package com.udemy.vueapi.survey.controller;

import com.udemy.vueapi.survey.domain.SurveyDomain;
import com.udemy.vueapi.survey.dto.SurveyDTO;
import com.udemy.vueapi.survey.entity.SurveyEntity;
import com.udemy.vueapi.survey.repository.SurveyRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SurveyController {

  private final SurveyRepository surveyRepository;

  @PostMapping("/api/survey")
  public ResponseEntity<SurveyDTO> createSurvey(@RequestBody SurveyDTO requestBody) {
    SurveyEntity postEntity = surveyRepository.save(SurveyDomain.of(requestBody).toCreateEntity());

    return ResponseEntity.status(HttpStatus.OK).body(SurveyDTO.toCreateDTO(postEntity));
  }

  @GetMapping("/api/survey")
  public ResponseEntity<List<SurveyDTO>> getSurvey() {
    List<SurveyEntity> surveyEntities = surveyRepository.findAll();

    List<SurveyDTO> surveyDTOList = surveyEntities.stream()
      .map(SurveyDTO::toCreateDTO)
      .toList();

    return ResponseEntity.status(HttpStatus.OK).body(surveyDTOList);
  }
}
