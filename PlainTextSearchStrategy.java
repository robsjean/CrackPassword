import java.util.Map;

public class PlainTextSearchStrategy implements PasswordSearchStrategy {
    private Map<String, String> passwordDictionary;

    public PlainTextSearchStrategy(Map<String, String> dictionary) {
        this.passwordDictionary = dictionary;
    }

    @Override
    public void searchPassword(String password) {
        boolean passwordFound = passwordDictionary.containsKey(password);

        if (passwordFound) {
            System.out.println("Mot de passe trouvé dans le dictionnaire.");
        } else {
            System.out.println("Mot de passe non trouvé dans le dictionnaire.");
        }
    }
}
