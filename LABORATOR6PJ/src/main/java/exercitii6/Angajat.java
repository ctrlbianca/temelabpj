package exercitii6;

import java.time.LocalDate;

public class Angajat {
    private String numele;
    private String postul;
    private LocalDate data_angajarii;
    private float salariul;

    public String getNumele() {
        return numele;
    }

    public String getPostul() {
        return postul;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public float getSalariul() {
        return salariul;
    }

    public String toString()
    {
        return numele+" "+postul+" "+data_angajarii+" "+salariul;
    }
}
