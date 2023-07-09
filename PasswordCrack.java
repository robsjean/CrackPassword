import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class PasswordCrack {
    public static void main(String[] args) {
        // Création du dictionnaire de mots de passe
        Map<String, String> passwordDictionary = new HashMap<>();

        // Lecture des fichiers de dictionnaire et ajout des mots de passe au dictionnaire
        readPasswordDictionary("Dico1.txt", passwordDictionary);
        readPasswordDictionary("Dico2.txt", passwordDictionary);
        readPasswordDictionary("Dico3.txt", passwordDictionary);

        // Demande à l'utilisateur de choisir l'option
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options:");
        System.out.println("1. Entrer un hash");
        System.out.println("2. Entrer un mot de passe");
        System.out.println("3. Attaque par force brute");
        System.out.print("Choisissez une option : ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante

        // Obtention de la stratégie de recherche en fonction de l'option choisie
        String searchType;
        if (option == 1) {
            searchType = "hash";
        } else if (option == 2) {
            searchType = "plaintext";
        } else if (option == 3) {
            searchType = "bruteforce";
        } else {
            System.out.println("Option invalide.");
            return;
        }
        PasswordSearchStrategy searchStrategy = PasswordSearchStrategyFactory.getPasswordSearchStrategy(searchType, passwordDictionary);

        // Demande à l'utilisateur d'entrer le hash ou le mot de passe
        System.out.print("Entrez le hash ou le mot de passe : ");
        String input = scanner.nextLine();

        // Utilisation de la stratégie de recherche
        searchStrategy.searchPassword(input);
    }

    private static void readPasswordDictionary(String fileName, Map<String, String> passwordDictionary) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                passwordDictionary.put(line, ""); // Laisse la valeur vide pour le moment, elle n'est pas utilisée dans cet exemple
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + fileName);
            e.printStackTrace();
        }
    }
}