package com.udemy.vueapi.coachesareas.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.vueapi.areas.entity.AreaEntity;
import com.udemy.vueapi.coaches.entity.CoachEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@Table(name = "coaches_areas")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CoachAreaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "area_id")
  private AreaEntity area;

  @JsonIgnore
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "coach_id")
  private CoachEntity coach;

  //==연관관계 메서드==//

  public void setCoach(CoachEntity coach) {
    this.coach = coach;
  }

  //==생성 메서드==//
  public static CoachAreaEntity createCoachArea(AreaEntity area) {
    return CoachAreaEntity.builder()
        .area(area)
        .build();
  }
}


