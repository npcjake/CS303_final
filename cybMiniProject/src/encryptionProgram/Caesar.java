package encryptionProgram;

public class Caesar {
    public String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            result.append(ch);
        }

        return result.toString();
    }

    public String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }
}

