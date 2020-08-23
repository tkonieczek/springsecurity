package pl.tk.model;

//import org.hibernate.annotations.CreationTimestamp;

//import javax.persistence.*;
import java.time.LocalDate;

//@Entity
public class Grade {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value; // wartość oceny

    //@Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

    // data wystawienia
   // @CreationTimestamp
    private LocalDate dateAdded; // now

    //@ManyToOne()
    private Student student;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public GradeSubject getSubject() {
        return subject;
    }

    public void setSubject(GradeSubject subject) {
        this.subject = subject;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
