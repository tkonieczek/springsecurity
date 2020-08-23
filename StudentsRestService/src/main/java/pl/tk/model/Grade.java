package pl.tk.model;

import java.time.LocalDateTime;


public class Grade {

    private Long id;

    private Subject przedmiot;

    private double ocena;

    private LocalDateTime dataDodania;

    private Student student;

    public Grade(Long id, Subject przedmiot, double ocena, LocalDateTime dataDodania, Student student) {

        this.id = id;
        this.przedmiot = przedmiot;
        this.ocena = ocena;
        this.dataDodania = dataDodania;
        this.student = student;
    }


    public Grade(Subject przedmiot, double ocena) {
        this.przedmiot = przedmiot;
        this.ocena = ocena;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Subject getPrzedmiot() {

        return przedmiot;
    }

    public void setPrzedmiot(Subject przedmiot) {

        this.przedmiot = przedmiot;
    }

    public double getOcena() {

        return ocena;
    }

    public void setOcena(double ocena) {

        this.ocena = ocena;
    }

    public LocalDateTime getDataDodania() {

        return dataDodania;
    }

    public void setDataDodania(LocalDateTime dataDodania) {

        this.dataDodania = dataDodania;
    }

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {

        this.student = student;
    }

    public Grade() {

    }

}
