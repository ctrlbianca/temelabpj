package exercitii4;
import java.io.Serializable;

public abstract class Echipament implements Serializable {
    protected String denumire;
    protected String nr_inv;
    protected double pret;
    protected String zona_mag;
    protected Stare stare;
    protected TipEchipament tipEchipament;

    public Echipament(String denumire, String nr_inv, double pret, String zona_mag, Stare stare, TipEchipament tipEchipament) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
        this.tipEchipament = tipEchipament;
    }

    public void schimbaStare(Stare stareNoua) {
        this.stare = stareNoua;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getNr_inv() {
        return nr_inv;
    }

    public double getPret() {
        return pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public Stare getStare() {
        return stare;
    }

    @Override
    public String toString() {
        return "Echipament [denumire=" + denumire + ", nr_inv=" + nr_inv + ", pret=" + pret + ", zona_mag=" + zona_mag + ", stare=" + stare + "]";
    }
}

