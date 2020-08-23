package pl.tk.dao;

import pl.tk.model.Student;

import java.util.List;


public interface StudentDAO {

    void save(Student studnet);

    Student findById(Long id);

    List<Student> findAll();

    void deleteById(Long id);

    void updateStudent(Student student);
}
