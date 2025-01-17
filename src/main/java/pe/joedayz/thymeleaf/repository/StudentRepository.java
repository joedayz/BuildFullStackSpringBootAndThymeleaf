package pe.joedayz.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.joedayz.thymeleaf.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
