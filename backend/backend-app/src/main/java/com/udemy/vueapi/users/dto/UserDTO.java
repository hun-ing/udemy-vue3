package com.udemy.vueapi.users.dto;

import com.udemy.vueapi.users.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

  private Long id;
  private String email;
  private String password;

  public static UserDTO toCreateDTO(UserEntity entity) {
    return UserDTO.builder()
      .id(entity.getId())
      .email(entity.getEmail())
      .password(entity.getPassword())
      .build();
  }
}
