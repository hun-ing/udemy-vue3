package com.udemy.vueapi.requests.dto;

import com.udemy.vueapi.entities.RequestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

  private Long id;
  private Long coachId;
  private String email;
  private String message;

  public static RequestDTO toCreateDTO(RequestEntity entity) {
    return RequestDTO.builder()
      .id(entity.getId())
      .email(entity.getEmail())
      .message(entity.getMessage())
      .coachId(entity.getCoachId())
      .build();
  }
}
