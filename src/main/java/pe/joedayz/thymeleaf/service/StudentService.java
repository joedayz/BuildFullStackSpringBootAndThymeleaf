package pe.joedayz.thymeleaf.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.joedayz.thymeleaf.entity.Student;
import pe.joedayz.thymeleaf.repository.AddressRepository;
import pe.joedayz.thymeleaf.repository.StudentRepository;

@AllArgsConstructor
@Service
public class StudentService {

  private AddressRepository addressRepository;
  private StudentRepository studentRepository;

  public Student save(Student student) {
    this.studentRepository.save(student);
    this.addressRepository.save(student.getAddress());
    return student;
  }
}
