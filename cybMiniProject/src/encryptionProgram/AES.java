package encryptionProgram;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AES {
	String text;
	public AES(String text) {
		if(text == null) {
			throw new IllegalArgumentException("Text cannot be null");
		}
		this.text = text;
	}
	public void encryptanddecrypt() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
		String input = this.text;
		SecretKey key = generateKey(128);
		IvParameterSpec ivParameterSpec = generateIv();
		String algorithm = "AES/CBC/PKCS5Padding";
		String cipherText = encrypt(algorithm, input, key, ivParameterSpec);
		String plainText = decrypt(algorithm, cipherText, key, ivParameterSpec);
		System.out.println("Encrypted: "+ cipherText + "\nDecrypted: " + plainText);
	}
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(n);
		SecretKey key = keyGenerator.generateKey();
		return key;
	}
	public static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}
	public static String encrypt(String algorithm, String input, SecretKey key,
			IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
	InvalidAlgorithmParameterException, InvalidKeyException,
	BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder()
				.encodeToString(cipherText);
	}
	public static String decrypt(String algorithm, String cipherText, SecretKey key,
			IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
	InvalidAlgorithmParameterException, InvalidKeyException,
	BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] plainText = cipher.doFinal(Base64.getDecoder()
				.decode(cipherText));
		return new String(plainText);
	}

}
