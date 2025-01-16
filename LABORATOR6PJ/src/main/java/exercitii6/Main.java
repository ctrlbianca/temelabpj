package exercitii6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Angajat> lista = citire();

        System.out.println("Cerinta 1");
        lista.stream().forEach(System.out::println);


        System.out.println('\n' + "Cerinta 2" + '\n');
        lista.stream()
                .filter(angajat -> angajat.getSalariul() > 2500)
                .forEach(System.out::println);

        System.out.println('\n' + "Cerinta 3" + '\n');
        LocalDate now = LocalDate.now();

        var lista_aplrile = lista.stream()
                .filter(angajat -> angajat.getPostul().equalsIgnoreCase("Sef")
                        || angajat.getPostul().equalsIgnoreCase("director"))
                .filter(angajat -> angajat.getData_angajarii().getYear() == now.minusYears(1).getYear())
                .filter(angajat -> angajat.getData_angajarii().getMonth() == Month.APRIL)
                .collect(Collectors.toList());

        lista_aplrile.stream()
                .forEach(System.out::println);

        System.out.println('\n' + "Cerinta 4" + '\n');

        lista.stream()
                .filter(angajat -> !angajat.getPostul().equalsIgnoreCase("Sef")
                        && !angajat.getPostul().equalsIgnoreCase("director"))
                .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                .forEach(System.out::println);

        System.out.println('\n' + "Cerinta 5" + '\n');

        var lista_nume = lista.stream()
                .map(angajat -> angajat.getNumele().toUpperCase())
                .toList();

        lista_nume.stream()
                .forEach(System.out::println);

        System.out.println('\n' + "Cerinta 6" + '\n');

        lista.stream()
                .filter(angajat -> angajat.getSalariul() < 3000)
                .map(angajat -> angajat.getSalariul())
                .forEach(System.out::println);

        System.out.println('\n' + "Cerinta 7" + '\n');

        lista.stream()
                .min(Comparator.comparing(Angajat::getData_angajarii))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nu esxita angajati"));

        System.out.println('\n' + "Cerinta 8" + '\n');

        var salariu = lista.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariul));

        System.out.println("Salariu maxi este : " + salariu.getMax());
        System.out.println("Salariu mediu este : " + String.format("%.1f", salariu.getAverage()));
        System.out.println("Salariu minim este : " + salariu.getMin());

        System.out.println('\n' + "Cerinta 9" + '\n');

        lista.stream()
                .filter(angajat -> angajat.getNumele().equalsIgnoreCase("Ion"))
                .findAny()
                .ifPresentOrElse(Ion -> System.out.println("Firma are cel puțin un Ion angajat")
                        ,() -> System.out.println("Firma nu are nici un Ion angajat"));

        System.out.println('\n' + "Cerinta 10" + '\n');

        var nr=lista.stream()
                .filter(angajat -> angajat.getData_angajarii().getYear()==now.minusYears(1).getYear())
                .filter(angajat -> angajat.getData_angajarii().getMonth().getValue()>=6
                        && angajat.getData_angajarii().getMonth().getValue()<=8)
                .count();

        System.out.println("Nurmarul de persoane agajate in vara anule precedent este de : "+nr);

        scriere(lista);
    }

    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> persoane = mapper
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .readValue(file, new TypeReference<List<Angajat>>() {
                    });
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}