import java.util.Scanner;

public class myWork {

    // Caesar Cipher methods
    public static String caesarEncrypt(String text, int shift) {
    //string builder for encryption
        StringBuilder result = new StringBuilder();
        //building the string
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            //if character append it to the string
            if (Character.isLetter(ch)) {
                //base value
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                //shifting it by the shift adding the base
                ch = (char) ((ch - base + shift) % 26 + base);
            }

            //appending our shifted

            result.append(ch);
        }

        return result.toString();
    }
    //decyrpt basically reversing the effect
    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }

    // Autokey Cipher methods
    public static String autokeyEncrypt(String text, String key) {
        //another string builder
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            //same process as last time
            if (Character.isLetter(ch)) {
                //lowercase
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                //a bit more complicated, 
                ch = (char) ((ch - base + (key.charAt(j) - 'a')) % 26 + base);
                j = ++j % key.length();
            }

            result.append(ch);
        }

        return result.toString();
    }

    public static String autokeyDecrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base - (key.charAt(j) - 'a') + 26) % 26 + base);
                j = ++j % key.length();
            }

            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose cipher type: 1 for Caesar Cipher, 2 for Autokey Cipher");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            // Caesar Cipher
            System.out.print("Enter a string for Caesar Cipher: ");
            String text = scanner.nextLine();

            System.out.print("Enter shift value: ");
            int shift = scanner.nextInt();

            String encryptedText = caesarEncrypt(text, shift);
            System.out.println("Caesar Encrypted Text: " + encryptedText);

            String decryptedText = caesarDecrypt(encryptedText, shift);
            System.out.println("Caesar Decrypted Text: " + decryptedText);

        } else if (choice == 2) {
            // Autokey Cipher
            System.out.print("Enter a string for Autokey Cipher: ");
            String text = scanner.nextLine();

            System.out.print("Enter key: ");
            String key = scanner.nextLine();

            String encryptedText = autokeyEncrypt(text, key);
            System.out.println("Autokey Encrypted Text: " + encryptedText);

            String decryptedText = autokeyDecrypt(encryptedText, key);
            System.out.println("Autokey Decrypted Text: " + decryptedText);

        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
