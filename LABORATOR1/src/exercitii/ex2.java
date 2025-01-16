package exercitii;
import java.io.*;
import java.util.*;
public class ex2 {
    public static void main(String[] args) {
        String inputFileName = "in.txt";
        String outputFileName = "out.txt";

        try {
            List<Integer> numere = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String linie;
            while ((linie = reader.readLine()) != null) {
                numere.add(Integer.parseInt(linie.trim()));
            }
            reader.close();
            int suma = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int numar : numere) {
                suma += numar;
                if (numar < min) {
                    min = numar;
                }
                if (numar > max) {
                    max = numar;
                }
            }
            double media = (double) suma / numere.size();
            System.out.println("Suma: " + suma);
            System.out.println("Media: " + media);
            System.out.println("Valoarea minimă: " + min);
            System.out.println("Valoarea maximă: " + max);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write("Suma: " + suma + "\n");
            writer.write("Media: " + media + "\n");
            writer.write("Valoarea minimă: " + min + "\n");
            writer.write("Valoarea maximă: " + max + "\n");
            writer.close();
            System.out.println("Rezultatele au fost scrise în fișierul " + outputFileName);
        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea sau scrierea fișierului: " + e.getMessage());
        }
    }
}
