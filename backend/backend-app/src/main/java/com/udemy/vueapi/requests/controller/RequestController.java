package com.udemy.vueapi.requests.controller;

import com.udemy.vueapi.requests.domain.RequestDomain;
import com.udemy.vueapi.requests.dto.RequestDTO;
import com.udemy.vueapi.entities.RequestEntity;
import com.udemy.vueapi.repositories.RequestRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestController {

  private final RequestRepository requestRepository;

  @PostMapping("/api/request")
  public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestDTO requestBody) {

    RequestEntity requestEntity = requestRepository.save(RequestDomain.of(requestBody).toCreateEntity());

    return ResponseEntity.status(HttpStatus.OK).body(RequestDTO.toCreateDTO(requestEntity));
  }

  @GetMapping("/api/requests/{coachId}")
  public ResponseEntity<List<RequestDTO>> findAllByCoachId(@PathVariable(name = "coachId") Long coachId) {

    List<RequestEntity> requestEntities = requestRepository.findAllByCoachId(coachId);

    List<RequestDTO> requests = requestEntities.stream()
        .map(RequestDTO::toCreateDTO)
        .toList();

    return ResponseEntity.status(HttpStatus.OK).body(requests);
  }
}
