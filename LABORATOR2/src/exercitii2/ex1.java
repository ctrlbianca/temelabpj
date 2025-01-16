package exercitii2;
import java.io.*;
import java.util.*;
public class ex1 {
        public static void main(String[] args) {
            String inputFileName = "judete_in.txt";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                List<String> judeteList = new ArrayList<>();
                String linie;

                while ((linie = reader.readLine()) != null) {
                    judeteList.add(linie.trim());
                }
                reader.close();
                String[] judete = judeteList.toArray(new String[0]);
                Arrays.sort(judete);
                System.out.println("Județele ordonate:");
                for (String judet : judete) {
                    System.out.println(judet);
                }
                Scanner scanner = new Scanner(System.in);
                System.out.print("Introduceți județul pe care doriți să îl căutați: ");
                String judetCautat = scanner.nextLine().trim();
                int pozitie = Arrays.binarySearch(judete, judetCautat);
                if (pozitie >= 0) {
                    System.out.println("Județul " + judetCautat + " se află pe poziția " + (pozitie + 1) + " în vectorul ordonat.");
                } else {
                    System.out.println("Județul " + judetCautat + " nu a fost găsit în listă.");
                }

            } catch (IOException e) {
                System.out.println("Eroare la citirea fișierului: " + e.getMessage());
            }
        }
    }

