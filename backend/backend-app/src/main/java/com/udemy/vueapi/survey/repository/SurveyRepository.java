package com.udemy.vueapi.survey.repository;

import com.udemy.vueapi.survey.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {

}
