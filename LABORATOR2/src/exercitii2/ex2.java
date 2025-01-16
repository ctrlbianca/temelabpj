package exercitii2;
import java.io.*;
import java.util.*;
public class ex2 {
        public static void main(String[] args) {
            String inputFileName = "cantec_in.txt";
            String outputFileName = "cantec_out.txt";
            String grupareLitere = "re";
            Random random = new Random();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                List<Vers> listaVersuri = new ArrayList<>();
                String linie;

                while ((linie = reader.readLine()) != null) {
                    listaVersuri.add(new Vers(linie.trim()));
                }
                reader.close();
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

                for (Vers vers : listaVersuri) {
                    String versOriginal = vers.getVers();
                    int numarCuvinte = vers.getNumarCuvinte();
                    int numarVocale = vers.getNumarVocale();
                    boolean seTerminaCuGrupare = vers.seTerminaCu(grupareLitere);
                    boolean scrieMajuscule = random.nextDouble() < 0.1;

                    // Construirea liniei pentru fișierul de ieșire
                    StringBuilder linieOutput = new StringBuilder();

                    if (scrieMajuscule) {
                        linieOutput.append(vers.transformaInMajuscule());
                    } else {
                        linieOutput.append(versOriginal);
                    }

                    linieOutput.append(" | Cuvinte: ").append(numarCuvinte);
                    linieOutput.append(" | Vocale: ").append(numarVocale);

                    if (seTerminaCuGrupare) {
                        linieOutput.append(" *");
                    }

                    writer.write(linieOutput.toString());
                    writer.newLine();
                }

                writer.close();
                System.out.println("Fișierul cantec_out.txt a fost generat cu succes.");

            } catch (IOException e) {
                System.out.println("Eroare la procesarea fișierului: " + e.getMessage());
            }
        }
    }
    class Vers {
        private String vers;
        public Vers(String vers) {
            this.vers = vers;
        }
        public int getNumarCuvinte() {
            if (vers.trim().isEmpty()) {
                return 0;
            }
            return vers.split("\\s+").length;
        }
        public int getNumarVocale() {
            int numarVocale = 0;
            for (char c : vers.toLowerCase().toCharArray()) {
                if ("aeiouăîâ".indexOf(c) != -1) {
                    numarVocale++;
                }
            }
            return numarVocale;
        }
        public boolean seTerminaCu(String grupare) {
            return vers.endsWith(grupare);
        }
        public String transformaInMajuscule() {
            return vers.toUpperCase();
        }
        public String getVers() {
            return vers;
        }
    }

