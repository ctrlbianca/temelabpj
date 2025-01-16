package exercitii2;
import java.util.Scanner;
public class ex3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceți șirul principal de caractere: ");
            StringBuilder sirPrincipal = new StringBuilder(scanner.nextLine());
            System.out.print("Introduceți șirul pe care doriți să-l inserați: ");
            String sirDeInserat = scanner.nextLine();
            System.out.print("Introduceți poziția unde doriți să inserați șirul: ");
            int pozitieInserare = scanner.nextInt();
            scanner.nextLine();
            if (pozitieInserare < 0 || pozitieInserare > sirPrincipal.length()) {
                System.out.println("Poziția de inserare este invalidă.");
            } else {
                sirPrincipal.insert(pozitieInserare, sirDeInserat);
                System.out.println("Șirul rezultat după inserare: " + sirPrincipal);
            }
            System.out.print("Introduceți poziția de început pentru ștergere: ");
            int pozitieStergere = scanner.nextInt();
            System.out.print("Introduceți numărul de caractere de șters: ");
            int numarCaractere = scanner.nextInt();
            if (pozitieStergere < 0 || pozitieStergere >= sirPrincipal.length() || pozitieStergere + numarCaractere > sirPrincipal.length()) {
                System.out.println("Poziția sau lungimea de ștergere este invalidă.");
            } else {
                sirPrincipal.delete(pozitieStergere, pozitieStergere + numarCaractere);
                System.out.println("Șirul rezultat după ștergere: " + sirPrincipal);
            }

            scanner.close();
        }
    }

