package com.udemy.vueapi.areas.controller;

import com.udemy.vueapi.repositories.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AreaController {

  private final AreaRepository areaRepository;
}
