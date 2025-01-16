package exercitii4;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Magazin {
    public List<Echipament> echipamente = new ArrayList<>();

    public void adaugaEchipament(Echipament echipament) {
        echipamente.add(echipament);
    }

    public void afiseazaToateEchipamentele() {
        for (Echipament echipament : echipamente) {
            System.out.println(echipament);
        }
    }

    public void afiseazaImprimante() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof Imprimanta) {
                System.out.println(echipament);
            }
        }
    }

    public void afiseazaCopiatoare() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof Copiator) {
                System.out.println(echipament);
            }
        }
    }

    public void afiseazaSistemeCalcul() {
        for (Echipament echipament : echipamente) {
            if (echipament instanceof SistemCalcul) {
                System.out.println(echipament);
            }
        }
    }

    public void afiseazaEchipamenteVandute() {
        for (Echipament echipament : echipamente) {
            if (echipament.getStare() == Stare.VANDUT) {
                System.out.println(echipament);
            }
        }
    }

    public static void serialize(List<Echipament> echipamente, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(echipamente);
        }
    }

    public static List<Echipament> deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Echipament>) in.readObject();
        }
    }
}
