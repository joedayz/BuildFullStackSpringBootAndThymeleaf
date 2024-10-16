package pe.joedayz.thymeleaf.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")  // http://localhost:8080/
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "redirect:/students";
    }
}
