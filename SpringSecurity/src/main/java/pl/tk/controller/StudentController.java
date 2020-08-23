package pl.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tk.config.UserService;
import pl.tk.model.Student;
import pl.tk.service.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;

    //  automatycznie robi autowired
    @Autowired
    public StudentController(StudentService studentService, UserService userService) {
        this.studentService = studentService;
        this.userService = userService;
    }

    //Zadanie 8
    @ModelAttribute("user")
    public String user() {
        return userService.currentUserName();
    }

    @GetMapping()
    public String getStudentForm(Model model, Student student) {
        model.addAttribute("student", student);
        return "student_form";
    }

    @PostMapping()
    public String updateStudent(Student student) {
        System.out.println("Dane: " + student);
        studentService.update(student);
        return "redirect:/student/list";
    }

    // localhost:8080/student/list
    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);

        return "student_list";
    }

    // localhost:8080/student/details?id=1
    @GetMapping("/details")
    public String getDetailsPage(Model model, @RequestParam(name = "id") Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isPresent()) { // jeśli uda się znaleźć studenta, to wyświetlimy widok szczegółowy
            Student student = studentOptional.get();
            model.addAttribute("student", student);

            return "student_details";
        } else {
            // nie uda się odnaleźć studenta to przekierowujemy z powrotem na listę
            return "redirect:/student/list";
        }
    }

    // localhost:8080/student/details?id=1
    @GetMapping("/edit")
    public String getEditPage(Model model, @RequestParam(name = "id") Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isPresent()) { // jeśli uda się znaleźć studenta, to wyświetlimy widok szczegółowy
            Student student = studentOptional.get();
            model.addAttribute("student", student);

            return "student_form";
        } else {
            // nie uda się odnaleźć studenta to przekierowujemy z powrotem na listę
            return "redirect:/student/list";
        }
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam(name = "id") Long id) {
        studentService.deleteById(id);

        return "redirect:/student/list";
    }
}
