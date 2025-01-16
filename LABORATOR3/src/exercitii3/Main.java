package exercitii3;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<ex2> produse = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Citirea din fișierul produse.csv
        try (BufferedReader reader = new BufferedReader(new FileReader("produse.csv"))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] date = linie.split(",");
                String denumire = date[0].trim();
                double pret = Double.parseDouble(date[1].trim());
                int cantitate = Integer.parseInt(date[2].trim());
                LocalDate dataExpirare = LocalDate.parse(date[3].trim());
                produse.add(new ex2(denumire, pret, cantitate, dataExpirare));
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }

        // Meniu
        while (true) {
            System.out.println("\n--- Meniu ---");
            System.out.println("1. Afișare produse");
            System.out.println("2. Afișare produse expirate");
            System.out.println("3. Vânzare produs");
            System.out.println("4. Afișare produse cu preț minim");
            System.out.println("5. Salvare produse cu cantitate mai mică decât o valoare");
            System.out.println("6. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline-ul

            switch (optiune) {
                case 1:
                    // Afișare produse
                    produse.forEach(System.out::println);
                    break;

                case 2:
                    // Afișare produse expirate
                    LocalDate azi = LocalDate.now();
                    produse.stream()
                            .filter(prod -> prod.getDataExpirare().isBefore(azi))
                            .forEach(System.out::println);
                    break;

                case 3:
                    // Vânzare produs
                    System.out.print("Introduceți denumirea produsului: ");
                    String denumire = scanner.nextLine();
                    System.out.print("Introduceți cantitatea de vândut: ");
                    int cantitateVanduta = scanner.nextInt();

                    Optional<ex2> produsOpt = produse.stream()
                            .filter(prod -> prod.getDenumire().equalsIgnoreCase(denumire))
                            .findFirst();

                    if (produsOpt.isPresent()) {
                        ex2 produs = produsOpt.get();
                        if (produs.getCantitate() >= cantitateVanduta) {
                            produs.setCantitate(produs.getCantitate() - cantitateVanduta);
                            ex2.adaugaIncasari(produs.getPret() * cantitateVanduta);
                            System.out.println("Produs vândut cu succes. Total încasări: " + ex2.getIncasari());
                            if (produs.getCantitate() == 0) {
                                produse.remove(produs);
                            }
                        } else {
                            System.out.println("Stoc insuficient.");
                        }
                    } else {
                        System.out.println("Produsul nu a fost găsit.");
                    }
                    break;

                case 4:
                    // Afișare produse cu preț minim
                    OptionalDouble pretMinimOpt = produse.stream()
                            .mapToDouble(ex2::getPret)
                            .min();

                    if (pretMinimOpt.isPresent()) {
                        double pretMinim = pretMinimOpt.getAsDouble();
                        produse.stream()
                                .filter(prod -> prod.getPret() == pretMinim)
                                .forEach(System.out::println);
                    } else {
                        System.out.println("Nu există produse.");
                    }
                    break;

                case 5:
                    // Salvare produse cu cantitate mai mică decât o valoare
                    System.out.print("Introduceți valoarea cantității: ");
                    int valoare = scanner.nextInt();
                    scanner.nextLine(); // Consumăm newline-ul

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("produse_filtrate.csv"))) {
                        produse.stream()
                                .filter(prod -> prod.getCantitate() < valoare)
                                .forEach(prod -> {
                                    try {
                                        writer.write(prod.toString());
                                        writer.newLine();
                                    } catch (IOException e) {
                                        System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
                                    }
                                });
                        System.out.println("Produsele au fost salvate în produse_filtrate.csv.");
                    } catch (IOException e) {
                        System.out.println("Eroare la scrierea fișierului: " + e.getMessage());
                    }
                    break;

                case 6:
                    // Ieșire
                    System.out.println("La revedere!");
                    return;

                default:
                    System.out.println("Opțiune invalidă.");
                    break;
            }
        }
    }
}
