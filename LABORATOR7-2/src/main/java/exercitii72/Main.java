package exercitii72;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {
        Set<InstrumentMuzical> set = new HashSet<InstrumentMuzical>();
        set = citire();

        System.out.println("4:");
        System.out.println("implementarea uitlizata: " + set.getClass().getName());


        System.out.println("\n5:");
        Chitara duplicata = new Chitara("Fender", 3000, TipChitara.ACUSTICA, 7);
        if(!set.add(duplicata))
        {
            System.out.println("duplicatele nu sunt permise in set");
        }
        else System.out.println("instrumentul a fost introdus cu succes in set");


        System.out.println("\n6:");
        System.out.println("lista instrumentelor inainte de stergere:");
        set.stream().forEach(InstrumentMuzical::Afisare);

        set.removeIf(lambda -> lambda.getPret() > 3000);

        System.out.println("\nlista instrumentelor dupa stergere:");
        set.stream().forEach(InstrumentMuzical::Afisare);


        System.out.println("\n7:");
        set.stream().filter(lambda -> lambda instanceof Chitara)
                .forEach(InstrumentMuzical::Afisare);


        System.out.println("\n8:");
        set.stream().filter(lambda -> lambda.getClass() == SetTobe.class)
                .forEach(InstrumentMuzical::Afisare);


        System.out.println("\n9:");
        set.stream().filter(lambda -> lambda instanceof Chitara)
                .map(m -> (Chitara) m)
                .max(Comparator.comparing(Chitara::getNr_corzi))
                .ifPresentOrElse(InstrumentMuzical::Afisare, ()-> System.out.println("doesn't exist"));


        System.out.println("\n10:");
        set.stream().filter(lambda -> lambda instanceof SetTobe)
                .map(m -> (SetTobe) m)
                .filter(mm -> mm.getTip_tobe()== TipTobe.ACUSTICE)
                .sorted(Comparator.comparing(SetTobe::getNr_tobe))
                .forEach(InstrumentMuzical::Afisare);

        scriere(set);
    }

    public static void scriere(Set<InstrumentMuzical> set) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file = new File("src/main/resources/instrumente.json");
            mapper.writeValue(file, set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<InstrumentMuzical> citire() {
        try {
            File file = new File("src/main/resources/instrumente.json");
            ObjectMapper mapper = new ObjectMapper();
            Set<InstrumentMuzical> instrumente = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzical>>() {
                    });
            return instrumente;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

