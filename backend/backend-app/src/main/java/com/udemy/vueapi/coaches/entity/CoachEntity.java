package com.udemy.vueapi.coaches.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.vueapi.coachesareas.entity.CoachAreaEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@Table(name = "coaches")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CoachEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String description;
  private String hourlyRate;

  @JsonIgnore
  @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
  private List<CoachAreaEntity> coachesAreas = new ArrayList<>();

  //==연관관계 메서드==//

  public void addCoachArea(CoachAreaEntity coachArea) {
    this.coachesAreas.add(coachArea);
    coachArea.setCoach(this);
  }
}


