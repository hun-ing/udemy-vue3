package com.udemy.vueapi.users.domain;

import com.udemy.vueapi.users.dto.UserDTO;
import com.udemy.vueapi.users.entity.UserEntity;
import lombok.Getter;


@Getter
public class UserDomain {

  private final Long id;
  private final String email;
  private final String password;

  private UserDomain(UserDTO dto) {
    this.id = dto.getId();
    this.email = dto.getEmail();
    this.password = dto.getPassword();
  }

  public static UserDomain of(UserDTO dto) {
    return new UserDomain(dto);
  }

  public UserEntity toCreateEntity() {
    return UserEntity.builder()
      .id(id)
      .email(email)
      .password(password)
      .build();
  }
}
