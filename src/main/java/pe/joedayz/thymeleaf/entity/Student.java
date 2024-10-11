package pe.joedayz.thymeleaf.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
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
  private LocalDate birthday;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private Address address;

  @PrePersist
  private void prePersist() {
    this.id = UUID.randomUUID().toString();
    this.createdAt = LocalDateTime.now();
  }

  @PreUpdate
  private void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

}
