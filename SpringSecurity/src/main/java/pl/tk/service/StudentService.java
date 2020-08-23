package pl.tk.service;

import pl.tk.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void update(Student student);

    List<Student> findAll();

    Optional<Student> findById(Long id);

    void deleteById(Long id);
}
