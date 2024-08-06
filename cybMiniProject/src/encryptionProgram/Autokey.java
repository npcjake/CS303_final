package encryptionProgram;
public class Autokey {
    public static String autokeyEncrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
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
}


