package exercitii5;

import java.util.List;

    public class Mobilier
    {
        private String nume;
        private List<Placa> placi;


        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public List<Placa> getPlaci() {
            return placi;
        }

        public void setPlaci(List<Placa> placi) {
            this.placi = placi;
        }
    }
