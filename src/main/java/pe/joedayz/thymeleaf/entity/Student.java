package pe.joedayz.thymeleaf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="student")
@EqualsAndHashCode(of = "id")
public class Student {

  @Id
  private String id;

  private String name;

  private String email;


}
