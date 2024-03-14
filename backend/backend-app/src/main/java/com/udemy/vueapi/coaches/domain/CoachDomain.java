package com.udemy.vueapi.coaches.domain;

import com.udemy.vueapi.coaches.dto.CoachDTO;
import com.udemy.vueapi.entities.CoachEntity;
import com.udemy.vueapi.entities.CoachAreaEntity;
import java.util.ArrayList;
import lombok.Getter;


@Getter
public class CoachDomain {

  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String description;
  private final int hourlyRate;

  private CoachDomain(CoachDTO dto) {
    this.id = dto.getId();
    this.firstName = dto.getFirstName();
    this.lastName = dto.getLastName();
    this.description = dto.getDescription();
    this.hourlyRate = dto.getHourlyRate();
  }

  public static CoachDomain of(CoachDTO dto) {
    return new CoachDomain(dto);
  }

  public CoachEntity toCreateEntity() {
    return CoachEntity.builder()
      .id(id)
      .firstName(firstName)
      .lastName(lastName)
      .description(description)
      .hourlyRate(hourlyRate)
      .coachesAreas(new ArrayList<CoachAreaEntity>())
      .build();
  }
}
