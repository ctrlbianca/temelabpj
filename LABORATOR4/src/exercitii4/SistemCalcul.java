package exercitii4;
public class SistemCalcul extends Echipament {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    public SistemCalcul(String denumire, String nr_inv, double pret, String zona_mag, Stare stare, String tip_mon, double vit_proc, int c_hdd, SistemOperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, stare, TipEchipament.SISTEM_CALCUL);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }

    public void instaleazaSistemOperare(SistemOperare so) {
        this.sistemOperare = so;
    }

    @Override
    public String toString() {
        return super.toString() + ", SistemCalcul [tip_mon=" + tip_mon + ", vit_proc=" + vit_proc + ", c_hdd=" + c_hdd + ", sistemOperare=" + sistemOperare + "]";
    }
}

