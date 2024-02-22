package com.udemy.vueapi.survey.domain;

import com.udemy.vueapi.survey.dto.SurveyDTO;
import com.udemy.vueapi.survey.entity.SurveyEntity;
import lombok.Getter;


@Getter
public class SurveyDomain {

  private Long id;
  private String name;
  private String rating;

  private SurveyDomain(SurveyDTO dto) {
    this.id = dto.getId();
    this.name = dto.getName();
    this.rating = dto.getRating();
  }

  public static SurveyDomain of(SurveyDTO dto) {
    return new SurveyDomain(dto);
  }

  public SurveyEntity toCreateEntity() {
    return SurveyEntity.builder()
      .id(id)
      .name(name)
      .rating(rating)
      .build();
  }
}
