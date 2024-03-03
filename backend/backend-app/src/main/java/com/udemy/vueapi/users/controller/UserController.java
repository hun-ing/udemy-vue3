package com.udemy.vueapi.users.controller;

import com.udemy.vueapi.users.domain.UserDomain;
import com.udemy.vueapi.users.dto.UserDTO;
import com.udemy.vueapi.users.entity.UserEntity;
import com.udemy.vueapi.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @PostMapping("/api/signup")
  public ResponseEntity<UserDTO> signup(@RequestBody UserDTO requestBody) {
    UserEntity userEntity = userRepository.save(UserDomain.of(requestBody).toCreateEntity());

    return ResponseEntity.status(HttpStatus.OK).body(UserDTO.toCreateDTO(userEntity));
  }
}
