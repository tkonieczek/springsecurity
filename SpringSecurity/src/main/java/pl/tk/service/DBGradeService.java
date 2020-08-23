package pl.tk.service;

import pl.tk.model.Grade;
import pl.tk.repository.GradeRepository;

//@Service
public class DBGradeService implements GradeService {

    private final GradeRepository gradeRepository;

    public DBGradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void update(Grade grade) {
       // gradeRepository.save(grade);
    }

    public void deleteById(Long id) {
        //gradeRepository.deleteById(id);
    }
}
