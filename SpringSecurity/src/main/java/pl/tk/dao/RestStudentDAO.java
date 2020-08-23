package pl.tk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.tk.model.Student;

import java.util.Arrays;
import java.util.List;


@Component("rest")
public class RestStudentDAO implements StudentDAO {

    @Value("${rest.students.url}")
    private String studentsUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override public void save(Student student) {
        Student addedStudent = restTemplate.postForObject(studentsUrl + "/students", student, Student.class);
    }

    @Override
    public void updateStudent(Student student) {
        restTemplate.put(studentsUrl + "/students/" + student.getId().toString(), student);
    }

    @Override public Student findById(Long id) {
        Student addedStudent = restTemplate.getForObject(studentsUrl + "/students/" + id.toString(), Student.class);
        return addedStudent;
    }

    @Override
    public List<Student> findAll() {
    //    restTemplate = new RestTemplate();
       // String url = "http://localhost:8081/students";
        ResponseEntity<Student[]> students = restTemplate.getForEntity(studentsUrl + "/students", Student[].class, HttpStatus.OK);
        Student[] body = students.getBody();
        return Arrays.asList(body);
    }

    @Override public void deleteById(Long id) {
        restTemplate.delete(studentsUrl + "/students/" + id.toString());
    }
}
