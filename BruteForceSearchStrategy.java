import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BruteForceSearchStrategy implements PasswordSearchStrategy {
    public void searchPassword(String password) {
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Caractères utilisés pour générer les mots de passe
        int maxLength = 8; // Longueur maximale d'un mot de passe

        // Boucle pour générer toutes les combinaisons possibles de mots de passe
        for (int length = 1; length <= maxLength; length++) {
            generatePasswords(password, charset, new char[length], 0);
        }

        // Mot de passe non trouvé
        System.out.println("Mot de passe correspondant non trouvé.");
    }

    private void generatePasswords(String password, String charset, char[] currentPassword, int position) {
        // Vérifier si le mot de passe courant correspond au mot de passe cible
        if (position == currentPassword.length) {
            String currentPasswordString = new String(currentPassword);
            if (currentPasswordString.equals(password)) {
                System.out.println("Mot de passe correspondant trouvé : " + currentPasswordString);
                System.exit(0); // Arrêter le programme après avoir trouvé le mot de passe
            }
            return;
        }

        // Générer les combinaisons de mots de passe récursivement
        for (int i = 0; i < charset.length(); i++) {
            currentPassword[position] = charset.charAt(i);
            generatePasswords(password, charset, currentPassword, position + 1);
        }
    }
}
