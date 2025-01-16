package exercitii7;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();


        Map<Integer, Carte> cartiMap = objectMapper.readValue(
                new File("carti.json"),
                new TypeReference<Map<Integer, Carte>>() {}
        );


        System.out.println("Colecția inițială de cărți:");
        cartiMap.forEach((id, carte) -> System.out.println("ID: " + id + " -> " + carte));


        int idToRemove = 2; // Exemplu ID de șters
        cartiMap.remove(idToRemove);
        System.out.println("\nDupă ștergerea cărții cu ID " + idToRemove + ":");
        cartiMap.forEach((id, carte) -> System.out.println("ID: " + id + " -> " + carte));


        Carte newCarte = new Carte("Cartea nouă", "Autor Nou", 2023);
        cartiMap.putIfAbsent(7, newCarte);
        System.out.println("\nDupă adăugarea unei noi cărți:");
        cartiMap.forEach((id, carte) -> System.out.println("ID: " + id + " -> " + carte));


        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("carti.json"), cartiMap);
        System.out.println("\nModificările au fost salvate în fișierul carti.json.");


        Set<Carte> harariBooks = cartiMap.values().stream()
                .filter(carte -> "Yuval Noah Harari".equals(carte.getAutorul()))
                .collect(Collectors.toSet());
        System.out.println("\nCărțile autorului Yuval Noah Harari:");
        harariBooks.forEach(System.out::println);


        System.out.println("\nCărțile ordonate după titlu:");
        harariBooks.stream()
                .sorted(Comparator.comparing(Carte::getTitlul))
                .forEach(System.out::println);

        Optional<Carte> oldestBook = harariBooks.stream()
                .min(Comparator.comparingInt(Carte::getAnul));
        oldestBook.ifPresent(carte -> System.out.println("\nCea mai veche carte: " + carte));
    }
}