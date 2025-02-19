package exercitii72;

public class SetTobe extends InstrumentMuzical
{
    private TipTobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe() {
        super();
    }

    public SetTobe(String producator, int pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public TipTobe getTip_tobe() {
        return tip_tobe;
    }

    public void setTip_tobe(TipTobe tip_tobe) {
        this.tip_tobe = tip_tobe;
    }

    public int getNr_tobe() {
        return nr_tobe;
    }

    public void setNr_tobe(int nr_tobe) {
        this.nr_tobe = nr_tobe;
    }

    public int getNr_cinele() {
        return nr_cinele;
    }

    public void setNr_cinele(int nr_cinele) {
        this.nr_cinele = nr_cinele;
    }

    @Override
    public void Afisare()
    {
        System.out.println("Set tobe, " + getProducator() + ", " + getPret() + ", tipul " + tip_tobe + ", cu nr tobe" + nr_tobe + " cu nr cinele " + nr_cinele);
    }

}