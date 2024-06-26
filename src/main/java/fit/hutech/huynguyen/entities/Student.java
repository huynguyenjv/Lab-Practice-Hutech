package fit.hutech.huynguyen.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private int age;
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Faculty must be a string")
    private String faculty;

}
