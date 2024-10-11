package pe.joedayz.thymeleaf.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.joedayz.thymeleaf.dto.CreateStudentDTO;
import pe.joedayz.thymeleaf.dto.StudentResponseDTO;
import pe.joedayz.thymeleaf.dto.mapper.StudentMapper;
import pe.joedayz.thymeleaf.repository.StudentRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

  //private StudentService studentService;
  private StudentRepository studentRepository;

  @GetMapping("/new")
  public ModelAndView showCreateForm() {
    return new ModelAndView("new-student").addObject("student",
        new CreateStudentDTO());
  }

  public ModelAndView showStudents() {
    List<StudentResponseDTO> students = StudentMapper.toDTO(this.studentRepository.findAll());
    return new ModelAndView("students").addObject("students", students);
  }

//  @GetMapping("/{id}")
//  public ModelAndView showUpdateForm(@PathVariable String id) {
//    StudentResponseDTO responseDTO = StudentMapper.toDTO(studentService.findById(id));
//    return new ModelAndView("edit-student").addObject("student",
//        new responseDTO());
//  }
}
