package pl.tk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.tk.dao.StudentDAO;
import pl.tk.model.Student;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DefaultStudentService implements StudentService {

    StudentDAO studentsDAO;

    @Autowired
    public DefaultStudentService(StudentDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @Override
    public void update(Student student) {
        if(null != student.getId()) {
            studentsDAO.updateStudent(student);
        } else {
            studentsDAO.save(student);
        }
    }

    @Override
    public List<Student> findAll() {
        return studentsDAO.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }

    public void deleteById(Long id) {
        studentsDAO.deleteById(id);
    }


}
