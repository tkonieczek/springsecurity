package pl.tk.model;

//import org.hibernate.annotations.Formula;

//import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

//@NoArgsConstructor
// POJO - Plain Old Java Object
//          - prywatne pola
//          - gettery settery
//          - pusty konstruktor (no args)
//@Entity
public class Student {
    //  @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;
    private String indexNumber; //unikalny
    private String firstName;
    private String lastName;

    public Student(Long id, String indexNumber, String firstName, String lastName, Double average, Gender gender, boolean active) {
        this.id = id;
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
        this.gender = gender;
        this.active = active;
    }

    public Student() {
        this.firstName = "Marian";
    }



    // SELECT id, active, average, firstName, gender, indexNumber, lastName, (select avg(g.value) from Grade g where g.student_id=s.id) as average2 FROM javagda34_hibernate_students.Student s;
    // pole adnotowane przez formula przestaje być kolumną
    // musi być wielką literą (Double), żeby wartość mogła być nullem (dzieje się tak w przypadku braku ocen)
    // @Formula(value = "(select avg(g.value) from grade g where g.student_id=id)")
    private Double average;

    //  @Enumerated(EnumType.STRING)
    private Gender gender;

    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Grade> getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(Set<Grade> gradeSet) {
        this.gradeSet = gradeSet;
    }

    //  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<Grade> gradeSet = new HashSet<>();
}
