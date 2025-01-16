package exercitii72;

public class Chitara extends InstrumentMuzical
{
    private TipChitara tip_chitara;
    private int nr_corzi;

    public Chitara()
    {
        super();
    }

    public Chitara(String producator, int pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }

    public TipChitara getTip_chitara() {
        return tip_chitara;
    }

    public void setTip_chitara(TipChitara tip_chitara) {
        this.tip_chitara = tip_chitara;
    }

    public int getNr_corzi() {
        return nr_corzi;
    }

    public void setNr_corzi(int nr_corzi) {
        this.nr_corzi = nr_corzi;
    }

    @Override
    public void Afisare() {
        System.out.println("Chitara, " + getProducator() + ", " + getPret() + " tipul " + tip_chitara + ", cu nr corzi " + nr_corzi);
    }

}
