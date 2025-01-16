package exercitii;
import java.util.Scanner;
public class ex3 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceți un număr natural: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Numărul introdus nu este natural. Introduceți un număr natural mai mare decât 0.");
                return;
            }
            System.out.println("Divizorii numărului " + n + " sunt:");
            boolean estePrim = true;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                    if (i != 1 && i != n) {
                        estePrim = false;
                    }
                }
            }
            if (estePrim && n > 1) {
                System.out.println("Numărul " + n + " este prim.");
            } else if (n > 1) {
                System.out.println("Numărul " + n + " nu este prim.");
            } else {
                System.out.println("Numărul " + n + " nu este considerat prim."); // Pentru n = 1
            }

            scanner.close();
        }
    }

