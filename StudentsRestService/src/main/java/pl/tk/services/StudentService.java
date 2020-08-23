package pl.tk.services;

import pl.tk.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    Optional<Student> getStudentById(String id);

    List<Student> getStudents();

    Student addStudent(Student student);

    void updateStudent(String id, Student student);

    boolean removeStudent(String id);
}
