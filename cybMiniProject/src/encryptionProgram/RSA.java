package encryptionProgram;
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class RSA {
    private PublicKey publicKey;
    private PrivateKey privateKey;

    // Method to generate the RSA key pair
    public void generateKeys() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048); // You can specify the key size (2048 bits in this case)
        KeyPair pair = keyPairGen.generateKeyPair();
        this.publicKey = pair.getPublic();
        this.privateKey = pair.getPrivate();
    }

    // Method to encrypt the plaintext using the public key
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt the ciphertext using the private key
    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes);
    }

    // Method to handle the RSA encryption/decryption process
    public void performEncryptionDecryption() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the plaintext:");
            String plaintext = scanner.nextLine();

            // Generate RSA key pair
            generateKeys();

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
