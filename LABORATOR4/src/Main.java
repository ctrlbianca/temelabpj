import exercitii4.*;
import exercitii4.Stare;
import exercitii4.TipEchipament;
import exercitii4.TipModul;
import exercitii4.FormatCopiere;
import exercitii4.SistemOperare;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Magazin magazin = new Magazin();
        magazin.adaugaEchipament(new Imprimanta("Imprimanta HP", "1234", 500.0, "Zona1", Stare.EXPUS, 30, 1200, 2000, TipModul.COLOR));
        magazin.adaugaEchipament(new Copiator("Copiator Canon", "5678", 300.0, "Zona2", Stare.ACHIZITIONAT, 1000, FormatCopiere.A4));
        magazin.adaugaEchipament(new SistemCalcul("PC Dell", "91011", 1500.0, "Zona3", Stare.EXPUS, "LED", 3.5, 1024, SistemOperare.WINDOWS));

        Scanner scanner = new Scanner(System.in);
        int optiune;
        do {
            System.out.println("Meniu:");
            System.out.println("1. Afisare toate echipamentele");
            System.out.println("2. Afisare imprimante");
            System.out.println("3. Afisare copiatoare");
            System.out.println("4. Afisare sisteme de calcul");
            System.out.println("5. Modifica stare echipament");
            System.out.println("6. Afisare echipamente vandute");
            System.out.println("0. Iesire");

            optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    magazin.afiseazaToateEchipamentele();
                    break;
                case 2:
                    magazin.afiseazaImprimante();
                    break;
                case 3:
                    magazin.afiseazaCopiatoare();
                    break;
                case 4:
                    magazin.afiseazaSistemeCalcul();
                    break;
                case 5:
                    System.out.println("Introduceti numarul de inventar al echipamentului de modificat:");
                    String nr_inv = scanner.next();
                    System.out.println("Introduceti noua stare (ACHIZIȚIONAT, EXPUZIT, VÂNDUT):");
                    String stareNoua = scanner.next().toUpperCase();
                    for (Echipament echipament : magazin.echipamente) {
                        if (echipament.getNr_inv().equals(nr_inv)) {
                            echipament.schimbaStare(Stare.valueOf(stareNoua));
                            System.out.println("Stare modificată!");
                        }
                    }
                    break;
                case 6:
                    magazin.afiseazaEchipamenteVandute();
                    break;
            }
        } while (optiune != 0);

        magazin.serialize(magazin.echipamente, "echip.bin");
        List<Echipament> echipamenteDinFisier = Magazin.deserialize("echip.bin");
        echipamenteDinFisier.forEach(System.out::println);
    }
}
