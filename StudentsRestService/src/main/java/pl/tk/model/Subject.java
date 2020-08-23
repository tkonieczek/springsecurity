package pl.tk.model;

public enum Subject {
    J_POLSKI("Język Polski"),
    J_ANGIELSKI ("Język Angielski"),
    INFORMATYKA ("Języki programowania"),
    MATEMATYKA (" Matematyka"),
    RELIGIA ("Religia");

    private String opis;

    Subject(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}
