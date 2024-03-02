package com.udemy.vueapi.coaches.dto;

import com.udemy.vueapi.areas.dto.AreaDTO;
import com.udemy.vueapi.coaches.entity.CoachEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoachDTO {

  private Long id;
  private String firstName;
  private String lastName;
  private String description;
  private String hourlyRate;
  private List<AreaDTO> areas;

  public static CoachDTO toCreateDTO(CoachEntity entity) {
    return CoachDTO.builder()
        .id(entity.getId())
        .firstName(entity.getFirstName())
        .lastName(entity.getLastName())
        .description(entity.getDescription())
        .hourlyRate(entity.getHourlyRate())
        .areas(entity.getCoachesAreas().stream().map(coachAreaEntity -> AreaDTO.toCreateDTO(coachAreaEntity.getArea())).toList())
        .build();
  }
}
