package exercitii;
import java.util.Random;
public class ex4 {
        public static void main(String[] args) {
            Random random = new Random();
            int numar1 = random.nextInt(30) + 1;
            int numar2 = random.nextInt(30) + 1;
            System.out.println("Numărul 1 generat: " + numar1);
            System.out.println("Numărul 2 generat: " + numar2);
            int cmmdc = calculeazaCmmdc(numar1, numar2);
            System.out.println("Cel mai mare divizor comun (CMMDC) al numerelor " + numar1 + " și " + numar2 + " este: " + cmmdc);
        }
        public static int calculeazaCmmdc(int a, int b) {
            while (b != 0) {
                int rest = a % b;
                a = b;
                b = rest;
            }
            return a;
        }
    }

