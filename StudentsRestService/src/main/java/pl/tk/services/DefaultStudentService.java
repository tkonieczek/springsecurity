package pl.tk.services;

import org.springframework.stereotype.Service;
import pl.tk.model.Grade;
import pl.tk.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//TODO Controler Advice
@Service
public class DefaultStudentService implements StudentService {

    List<Student> students;

/*    @Autowired
    JdbcTemplate jdbcTemplate;*/
    public DefaultStudentService() {
        students = new ArrayList<>();
        students.add(new Student(1L, "1", "Mariusz", "Januszewski", null));
        students.add(new Student(2L, "2", "Sebastian", "Kowalski", null));
        students.add(new Student(3L, "3", "Janusz", "Nowak",null));
        students.add(new Student(4L, "4", "Grażyna", "Januszewski", null));
        students.add(new Student(5L, "5", "Mariusz", "Januszewski",  null));
    }

    @Override public Optional<Student> getStudentById(String id) {
        Long idAsLong = Long.valueOf(id);
        return students.stream().filter(s -> s.getId().equals(idAsLong)).findFirst();
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Student addStudent(Student student) {
        Optional<Student> max = students.stream().max(Comparator.comparing(Student::getId));
        Long newId = max.map(Student::getId).orElse(1L);
        student.setId(newId);
        students.add(student);
        return student;
    }
    //public Student(Long id, String indexNumber, String firstName, String lastName, List<Grade> gradeList) {
    @Override public void updateStudent(String id, Student student) {
        Optional<Student> currentStudent = getStudentById(id);
        currentStudent.ifPresent(current -> {
            current.setFirstName(student.getFirstName());
            current.setLastName(student.getLastName());
            current.setIndexNumber(student.getIndexNumber());
            current.setGradeList(student.getGradeList());
        });
    }

    @Override public boolean removeStudent(String id) {
        Long idAsLong = Long.parseLong(id);
        return students.removeIf(next -> idAsLong.equals(next.getId()));
    }
}
