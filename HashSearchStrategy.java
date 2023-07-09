import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashSearchStrategy implements PasswordSearchStrategy {
    private Map<String, String> passwordDictionary;

    public HashSearchStrategy(Map<String, String> dictionary) {
        this.passwordDictionary = dictionary;
    }

    public void searchPassword(String hash) {
        boolean passwordFound = false;
        for (Map.Entry<String, String> entry : passwordDictionary.entrySet()) {
            String password = entry.getKey();
            String passwordHash = getMD5Hash(password);

            if (passwordHash.equals(hash)) {
                System.out.println("Mot de passe correspondant trouvé : " + password);
                passwordFound = true;
                break;
            }

            // Affichage du mot de passe en cours de vérification
            System.out.println("Vérification en cours : " + password);
        }

        if (!passwordFound) {
            System.out.println("Mot de passe correspondant non trouvé.");
        }
    }

    private String getMD5Hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}