package pe.joedayz.thymeleaf.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.joedayz.thymeleaf.dto.CreateStudentDTO;
import pe.joedayz.thymeleaf.dto.StudentResponseDTO;
import pe.joedayz.thymeleaf.dto.UpdateStudentDTO;
import pe.joedayz.thymeleaf.dto.mapper.StudentMapper;
import pe.joedayz.thymeleaf.repository.StudentRepository;
import pe.joedayz.thymeleaf.service.StudentService;

@Controller
@AllArgsConstructor
@RequestMapping("/students")  // http://localhost:8080/students
public class StudentController {

  private StudentService studentService;
  private StudentRepository studentRepository;


  @GetMapping("/new")  // http://localhost:8080/students/new
  public ModelAndView showCreateForm() {
    return new ModelAndView("new-student").addObject("student",
        new CreateStudentDTO());
  }

  @GetMapping
  public ModelAndView showStudents() {
    List<StudentResponseDTO> students = StudentMapper.toDTO(this.studentRepository.findAll());
    return new ModelAndView("students").addObject("students", students);
  }

  @PostMapping("/new")  // http://localhost:8080/students/new
  public String createStudent(CreateStudentDTO studentDTO , BindingResult result, RedirectAttributes attributes){
    if (result.hasErrors()) {
      return "new-student";
    }
    this.studentService.save(StudentMapper.toEntity(studentDTO));
    attributes.addFlashAttribute("message", "User registered successfully!");
    return "redirect:/students";
  }

  @GetMapping("/{id}/delete")
  public String deleteStudent(@PathVariable String id, RedirectAttributes attributes) {
    this.studentRepository.deleteById(id);
    attributes.addFlashAttribute("message", "User deleted successfully!");
    return "redirect:/students";
  }

  @GetMapping("/{id}")
  public ModelAndView showStudent(@PathVariable String id) {
    StudentResponseDTO student = StudentMapper.toDTO(this.studentRepository.findById(id).get());
    return new ModelAndView("edit-student").addObject("student", student);
  }

  @PostMapping("/{id}")
  public String update(@PathVariable String id, @ModelAttribute("student") @Valid UpdateStudentDTO studentDTO,
      BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      studentDTO.setId(id);
      return "edit-student";
    }

    this.studentService.update(id, StudentMapper.toEntity(studentDTO));
    attributes.addFlashAttribute("message", "User updated successfully!");
    return "redirect:/students";
  }


}
