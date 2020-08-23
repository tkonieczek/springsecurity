package pl.tk.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.tk.model.Gender;
import pl.tk.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Component
@Primary
public class MockStudentsDAO implements StudentDAO {

    List<Student> students;

    public MockStudentsDAO() {
        students = new ArrayList<>();
        students.add(new Student(1L, "zm1", "Zygmunt", "Marek", 4.0, Gender.MALE, true));
        //Student(Long id, String indexNumber, String firstName,
        // String lastName, Double average, Gender gender, boolean active)
    }

    @Override
    public void save(Student student) {
        OptionalInt max = students.stream().mapToInt(s -> s.getId().intValue()).max();
        student.setId((long) max.getAsInt() + 1);
        students.add(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> first = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void deleteById(Long id) {
        students.removeIf(s -> s.getId() == id);
    }

    @Override
    public void updateStudent(Student student) {
        Optional<Student> first = students.stream().filter(s -> s.getId().equals(student.getId())).findFirst();
        first.ifPresent(s -> {
            s.setIndexNumber(student.getIndexNumber());
            s.setLastName(student.getLastName());
            s.setFirstName(student.getFirstName());
            s.setActive(student.isActive());
            s.setAverage(student.getAverage());
            s.setGender(student.getGender());
        });
    }
}
