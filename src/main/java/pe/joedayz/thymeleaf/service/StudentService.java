package pe.joedayz.thymeleaf.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.joedayz.thymeleaf.entity.Student;
import pe.joedayz.thymeleaf.repository.AddressRepository;
import pe.joedayz.thymeleaf.repository.StudentRepository;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@Service
public class StudentService {

  private AddressRepository addressRepository;
  private StudentRepository studentRepository;

  public Student findById(String id) {
    return this.studentRepository.findById(id).orElseThrow();
  }

  public Student save(Student student) {
    this.studentRepository.save(student);
    this.addressRepository.save(student.getAddress());
    return student;
  }

  public Student update(String id, Student student){
    Student studentDatabase = this.findById(id);
    BeanUtils.copyProperties(student, studentDatabase, "id", "createdAt", "updatedAt", "address");
    BeanUtils.copyProperties(student.getAddress(), studentDatabase.getAddress(), "id", "createdAt", "updatedAt", "student");
    return this.studentRepository.save(studentDatabase);
  }
}
