package exercitii7;



class Carte {
    private String titlul;
    private String autorul;
    private int anul;

    // Constructor
    public Carte(String titlul, String autorul, int anul) {
        this.titlul = titlul;
        this.autorul = autorul;
        this.anul = anul;
    }

    // Getters
    public String getTitlul() {
        return titlul;
    }

    public String getAutorul() {
        return autorul;
    }

    public int getAnul() {
        return anul;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlul='" + titlul + '\'' +
                ", autorul='" + autorul + '\'' +
                ", anul=" + anul +
                '}';
    }
}

