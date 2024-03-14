package com.udemy.vueapi.requests.domain;

import com.udemy.vueapi.requests.dto.RequestDTO;
import com.udemy.vueapi.entities.RequestEntity;
import lombok.Getter;


@Getter
public class RequestDomain {

  private final Long id;
  private final Long coachId;
  private final String email;
  private final String message;

  private RequestDomain(RequestDTO dto) {
    this.id = dto.getId();
    this.email = dto.getEmail();
    this.message = dto.getMessage();
    this.coachId = dto.getCoachId();
  }

  public static RequestDomain of(RequestDTO dto) {
    return new RequestDomain(dto);
  }

  public RequestEntity toCreateEntity() {
    return RequestEntity.builder()
      .id(id)
      .email(email)
      .message(message)
      .coachId(coachId)
      .build();
  }
}
