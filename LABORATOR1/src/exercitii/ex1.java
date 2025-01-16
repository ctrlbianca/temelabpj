package exercitii;
import java.util.Scanner;
public class ex1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceți lungimea dreptunghiului: ");
            int lungime = scanner.nextInt();
            System.out.print("Introduceți lățimea dreptunghiului: ");
            int latime = scanner.nextInt();
            int perimetru = 2 * (lungime + latime);
            int aria = lungime * latime;
            System.out.println("Perimetrul dreptunghiului este: " + perimetru);
            System.out.println("Aria dreptunghiului este: " + aria);
            scanner.close();
        }
    }


