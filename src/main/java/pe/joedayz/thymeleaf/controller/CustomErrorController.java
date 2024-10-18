package pe.joedayz.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CustomErrorController implements ErrorController {

  private final ErrorAttributes errorAttributes;

  public CustomErrorController(ErrorAttributes errorAttributes) {
    this.errorAttributes = errorAttributes;
  }

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, Model model) {
    WebRequest webRequest = new ServletWebRequest(request);
    Throwable error = errorAttributes.getError(webRequest);

    model.addAttribute("status", request.getAttribute("javax.servlet.error.status_code"));

    return "exception"; // nombre de la vista de error
  }
}
