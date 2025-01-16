package exercitiul1;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere() {
    }

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String toString() {
        return a + " " + b;
    }

    public boolean perecheFibonaci(int a, int b) {
        int i;
        int[] fib = new int[30];
        fib[0] = 0;
        fib[1] = 1;
        for (i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (i = 0; i < fib.length; i++) {
            if (fib[i] == a && fib[i + 1] == b) {
                return true;
            }
        }
        return false;
    }


    public int cmmc(int a, int b) {
        int x = a, z = b;
        while (x != z) {
            if (x < z) {
                x = x + a;
            } else {
                z = z + b;
            }
        }
        return x;
    }

    public boolean sumaEgala(int a, int b) {
        int sa = 0, sb = 0;
        while (a != 0) {
            sa = sa + a % 10;
            a = a / 10;
        }
        while (b != 0) {
            sb = sb + b % 10;
            b = b / 10;
        }

        return sa == sb;
    }


    public boolean nrCifrePare(int a, int b) {
        int nr_a = 0, nr_b = 0;
        while (a != 0) {
            if (a % 10 % 2 == 0) {
                nr_a++;
            }
            a = a / 10;
        }
        while (b != 0) {
            if (b % 10 % 2 == 0) {
                nr_b++;
            }
            b = b / 10;
        }

        if (nr_a == nr_b) {
            return true;
        } else {
            return false;
        }
    }
}
