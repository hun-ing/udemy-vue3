package com.udemy.vueapi.areas.dto;

import com.udemy.vueapi.entities.AreaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO {

  private Long id;
  private String area;

  public static AreaDTO toCreateDTO(AreaEntity entity) {
    return AreaDTO.builder()
      .id(entity.getId())
      .area(entity.getArea())
      .build();
  }
}
