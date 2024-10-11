package pe.joedayz.thymeleaf.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
public class CreateStudentDTO {

    @NotEmpty(message = "{NotEmpty.name}")
    private String name;

    @Email
    @NotEmpty(message = "{NotEmpty.email}")
    private String email;

    @NotNull(message = "{NotNull.birthday}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotEmpty(message = "{NotEmpty.street}")
    private String street;

    @NotEmpty(message = "{NotEmpty.number}")
    private String number;

    @NotEmpty(message = "{NotEmpty.district}")
    private String district;

    @NotEmpty(message = "{NotEmpty.city}")
    private String city;

    @NotEmpty(message = "{NotEmpty.state}")
    private String state;

}
