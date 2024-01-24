package example.everytime.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class College {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long collegeId;

  private String name;
}
