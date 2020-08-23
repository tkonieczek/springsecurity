package pl.tk.service;

import pl.tk.model.Grade;

public interface GradeService {

    public void update(Grade grade);

    public void deleteById(Long id);
}
