import java.util.Map;
import java.util.Scanner;

public class PasswordSearchStrategyFactory {
    public static PasswordSearchStrategy getPasswordSearchStrategy(String searchType, Map<String, String> dictionary) {
        if (searchType.equalsIgnoreCase("hash")) {
            return new HashSearchStrategy(dictionary);
        } else if (searchType.equalsIgnoreCase("plaintext")) {
            return new PlainTextSearchStrategy(dictionary);
        } else if (searchType.equalsIgnoreCase("bruteforce")) {
            return new BruteForceSearchStrategy();
        } else {
            throw new IllegalArgumentException("Type de recherche invalide.");
        }
    }
}
