package exercitii;
import java.util.Random;
public class ex5 {
        public static void main(String[] args) {
            Random random = new Random();
            int numar = random.nextInt(21);
            System.out.println("Numărul generat este: " + numar);
            if (esteFibonacci(numar)) {
                System.out.println("Numărul " + numar + " aparține șirului lui Fibonacci.");
            } else {
                System.out.println("Numărul " + numar + " nu aparține șirului lui Fibonacci.");
            }
        }
        public static boolean esteFibonacci(int n) {
            return estePatratPerfect(5 * n * n + 4) || estePatratPerfect(5 * n * n - 4);
        }
        public static boolean estePatratPerfect(int x) {
            int sqrt = (int) Math.sqrt(x);
            return sqrt * sqrt == x;
        }
    }

