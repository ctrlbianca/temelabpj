package EXERCITII8;

public class Excursie {
    private int idExcursie;
    private int idPersoana;
    private String destinatia;
    private int anul;

    public Excursie(int idExcursie, int idPersoana, String destinatia, int anul) {
        this.idExcursie = idExcursie;
        this.idPersoana = idPersoana;
        this.destinatia = destinatia;
        this.anul = anul;
    }

    public int getIdExcursie() { return idExcursie; }
    public int getIdPersoana() { return idPersoana; }
    public String getDestinatia() { return destinatia; }
    public int getAnul() { return anul; }
}

