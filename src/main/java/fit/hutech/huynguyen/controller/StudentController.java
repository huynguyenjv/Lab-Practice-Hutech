package fit.hutech.huynguyen.controller;

import fit.hutech.huynguyen.entities.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping("/student")
    public String submitForm(@Valid Student student, BindingResult bindingResult,
                             Model model){
        if (bindingResult.hasErrors()) {
            return "student/form";
        }
        model.addAttribute("message", "Sinh viên đã được thêm thành công!");
        return "student/result-form";
    }
}
