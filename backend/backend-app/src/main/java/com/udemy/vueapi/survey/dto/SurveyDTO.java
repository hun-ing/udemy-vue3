package com.udemy.vueapi.survey.dto;

import com.udemy.vueapi.survey.entity.SurveyEntity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDTO {

  private Long id;
  private String name;
  private String rating;

  public static SurveyDTO toCreateDTO(SurveyEntity entity) {
    return SurveyDTO.builder()
      .id(entity.getId())
      .name(entity.getName())
      .rating(entity.getRating())
      .build();
  }
}
