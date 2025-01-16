package exercitii72;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)

public abstract class InstrumentMuzical
{
    private String producator;
    private int pret;

    public InstrumentMuzical(){}

    public InstrumentMuzical(String producator, int pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public abstract void Afisare();

    @Override
    public boolean equals(Object object)
    {
        if(this == object)return true;
        if(object == null || getClass() != object.getClass()) return false;
        InstrumentMuzical instr =(InstrumentMuzical) object;
        return this.producator.equals(instr.producator) && this.pret == instr.pret;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(producator,pret);
    }
}