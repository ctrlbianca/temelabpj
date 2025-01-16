package EXERCITII8;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int option;

            do {
                System.out.println("1. Adaugă o persoană");
                System.out.println("0. Ieșire");
                System.out.print("Alege opțiunea: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> adaugaPersoana(scanner);
                    case 0 -> System.out.println("La revedere!");
                    default -> System.out.println("Opțiune invalidă!");
                }
            } while (option != 0);
        }
    }

    private static void adaugaPersoana(Scanner scanner) {
        System.out.print("Introdu numele: ");
        String nume = scanner.nextLine();

        int varsta = 0;
        while (true) {
            try {
                System.out.print("Introdu vârsta: ");
                varsta = Integer.parseInt(scanner.nextLine());
                if (varsta < 0 || varsta > 120) {
                    throw new ExceptieVarsta("Vârsta trebuie să fie între 0 și 120.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vârsta trebuie să fie un număr.");
            } catch (ExceptieVarsta e) {
                System.out.println(e.getMessage());
            }
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO persoane (nume, varsta) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nume);
            statement.setInt(2, varsta);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Persoana a fost adăugată cu succes!");
            }
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea persoanei: " + e.getMessage());
        }
    }
}
