package encryptionProgram;

import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	String text;
	private SecretKey secretKey;
	public AES(String text) {
		if(text == null) {
			throw new IllegalArgumentException("Text cannot be null");
		}
		this.text = text;
	}
	/**
	 * Method to encrypt and decrypt
	 */
	public void encryptanddecrypt()   {
		try {
			Scanner scanner = new Scanner(System.in);

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
				secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			}
			// Encrypt the plaintext
			String encryptedText = encrypt(text);
			System.out.println("Encrypted Text: " + encryptedText);

			// Decrypt the ciphertext
			String decryptedText = decrypt(encryptedText);
			System.out.println("Decrypted Text: " + decryptedText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Generates a random key
	 * @throws Exception
	 */
	public void generateKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		this.secretKey = keyGenerator.generateKey();
	}
	/**
	 * Encrypts using AES algorithm 
	 * @param text - the text to be encrypted
	 * @return - encrypted string
	 * @throws Exception
	 */
	public String encrypt(String text)throws Exception{
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(text.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	/**
	 * Decrypts using AES algorithm
	 * @param text - the text to be decrypted
	 * @return - decrypted string
	 * @throws Exception
	 */
	public String decrypt(String text) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
		return new String(decryptedBytes);
	}

}
