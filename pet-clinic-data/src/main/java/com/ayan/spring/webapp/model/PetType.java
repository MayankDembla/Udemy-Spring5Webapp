package com.ayan.spring.webapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

  @Column(name = "name")
  String name;

  @Override
  public String toString() {
    return name;
  }
}
