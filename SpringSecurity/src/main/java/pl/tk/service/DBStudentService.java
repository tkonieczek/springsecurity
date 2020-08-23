package pl.tk.service;

import pl.tk.model.Student;
import pl.tk.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class DBStudentService implements StudentService {

    private final StudentRepository studentRepository;

    public DBStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void update(Student student) {
        // zapis do bazy
       // studentRepository.save(student);
    }

    public List<Student> findAll() {
        return null;
       // return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return null;
       // return studentRepository.findById(id);
    }

    public void deleteById(Long id) {
        //studentRepository.deleteById(id);
    }
}
