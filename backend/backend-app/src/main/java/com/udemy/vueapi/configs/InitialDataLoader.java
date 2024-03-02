package com.udemy.vueapi.configs;

import com.udemy.vueapi.areas.domain.AreaDomain;
import com.udemy.vueapi.areas.dto.AreaDTO;
import com.udemy.vueapi.areas.repository.AreaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitialDataLoader {

  private final AreaRepository areaRepository;

  @PostConstruct
  public void init() {

    AreaDTO frontend = AreaDTO.builder().area("frontend").build();
    AreaDTO backend = AreaDTO.builder().area("backend").build();
    AreaDTO career = AreaDTO.builder().area("career").build();

    areaRepository.save(AreaDomain.of(frontend).toCreateEntity());
    areaRepository.save(AreaDomain.of(backend).toCreateEntity());
    areaRepository.save(AreaDomain.of(career).toCreateEntity());
  }
}
