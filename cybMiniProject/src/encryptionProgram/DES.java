package encryptionProgram;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class DES {
    private SecretKey secretKey;

    // Method to generate a random DES key
    public void generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56); // DES uses a 56-bit key
        this.secretKey = keyGen.generateKey();
    }

    // Method to encrypt the plaintext using the secret key
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt the ciphertext using the secret key
    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes);
    }

    // Method to handle the DES encryption/decryption process
    public void performEncryptionDecryption() {
        try {
            Scanner scanner = new Scanner(System.in);
            
            // Prompt for plaintext
            System.out.println("Enter the plaintext:");
            String plaintext = scanner.nextLine();
            
            // Ask the user if they have a key
            System.out.println("Do you have a key? (yes/no)");
            String keyResponse = scanner.nextLine();
            
            if (keyResponse.equalsIgnoreCase("no")) {
                // Generate a random key if not provided
                generateKey();
                System.out.println("Generated Key (Base64): " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));
            } else {
                // Prompt for the key
                System.out.println("Enter the key (Base64 encoded):");
                String keyInput = scanner.nextLine();
                byte[] decodedKey = Base64.getDecoder().decode(keyInput);
                secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
            }

            // Encrypt the plaintext
            String encryptedText = encrypt(plaintext);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt the ciphertext
            String decryptedText = decrypt(encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
