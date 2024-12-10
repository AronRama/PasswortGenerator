import java.util.Random;
import java.util.Scanner;

public class PasswortGenerator {
    public static String generatePassword(int length, boolean useUppercase, boolean useDigits, boolean useSymbols) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String characters = lowercase;
        if (useUppercase) {
            characters += uppercase;
        }
        if (useDigits) {
            characters += digits;
        }
        if (useSymbols) {
            characters += symbols;
        }

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen beim Passwortgenerator!");
        System.out.print("Wie lang soll das Passwort sein? (z. B. 12): ");
        int length = scanner.nextInt();

        System.out.print("Großbuchstaben verwenden? (ja/nein): ");
        boolean useUppercase = scanner.next().equalsIgnoreCase("ja");

        System.out.print("Zahlen verwenden? (ja/nein): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("ja");

        System.out.print("Sonderzeichen verwenden? (ja/nein): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("ja");

        String password = generatePassword(length, useUppercase, useDigits, useSymbols);
        System.out.println("Dein generiertes Passwort lautet: " + password);

        scanner.close();
    }
}
