package exercitii4;
public class Imprimanta extends Echipament {
    private int ppm;
    private int dpi;
    private int p_car;
    private TipModul modulTiparire;

    public Imprimanta(String denumire, String nr_inv, double pret, String zona_mag, Stare stare, int ppm, int dpi, int p_car, TipModul modulTiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare, TipEchipament.IMPRIMANTA);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.modulTiparire = modulTiparire;
    }

    public void seteazaModTiparire(TipModul modul) {
        this.modulTiparire = modul;
    }

    @Override
    public String toString() {
        return super.toString() + ", Imprimanta [ppm=" + ppm + ", dpi=" + dpi + ", p_car=" + p_car + ", modulTiparire=" + modulTiparire + "]";
    }
}

