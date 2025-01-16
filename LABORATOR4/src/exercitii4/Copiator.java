package exercitii4;
public class Copiator extends Echipament {
    private int p_ton;
    private FormatCopiere formatCopiere;

    public Copiator(String denumire, String nr_inv, double pret, String zona_mag, Stare stare, int p_ton, FormatCopiere formatCopiere) {
        super(denumire, nr_inv, pret, zona_mag, stare, TipEchipament.COPIATOR);
        this.p_ton = p_ton;
        this.formatCopiere = formatCopiere;
    }

    public void seteazaFormatCopiere(FormatCopiere format) {
        this.formatCopiere = format;
    }

    @Override
    public String toString() {
        return super.toString() + ", Copiator [p_ton=" + p_ton + ", formatCopiere=" + formatCopiere + "]";
    }
}
