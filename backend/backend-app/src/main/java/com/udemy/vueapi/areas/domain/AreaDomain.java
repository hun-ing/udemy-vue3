package com.udemy.vueapi.areas.domain;

import com.udemy.vueapi.areas.dto.AreaDTO;
import com.udemy.vueapi.areas.entity.AreaEntity;
import lombok.Getter;


@Getter
public class AreaDomain {

  private final Long id;
  private final String area;

  private AreaDomain(AreaDTO dto) {
    this.id = dto.getId();
    this.area = dto.getArea();
  }

  public static AreaDomain of(AreaDTO dto) {
    return new AreaDomain(dto);
  }

  public AreaEntity toCreateEntity() {
    return AreaEntity.builder()
      .id(id)
      .area(area)
      .build();
  }
}
