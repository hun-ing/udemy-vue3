package com.udemy.vueapi.areas.controller;

import com.udemy.vueapi.areas.domain.AreaDomain;
import com.udemy.vueapi.areas.dto.AreaDTO;
import com.udemy.vueapi.areas.entity.AreaEntity;
import com.udemy.vueapi.areas.repository.AreaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AreaController {

  private final AreaRepository areaRepository;
}
