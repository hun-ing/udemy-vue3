package com.udemy.vueapi.survey.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SurveyDTO {

  private Long id;
  private String name;
  private String rating;
}
