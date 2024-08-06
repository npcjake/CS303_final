package encryptionProgram;

import java.util.Arrays;

public class RailFence {
	private String text;
	private int key;

	/**
	 * The constructor the rail fence cipher
	 * @param text - string input of the user
	 * @param key - integer input of the user corresponding to the key
	 * @throws IllegalArgumentException - if string is null or key is less than 0
	 */
	public RailFence(String text, int key) {
		if(text == null || key < 0) {
			throw new IllegalArgumentException("Cannot be null or 0");
		}
		this.text = text;
		this.key = key;
	}
	/**
	 * method to encrypt using rail fence
	 */
	public void encryptanddecrypt() {
		String encryptedMessage = encrypt(this.text);
		System.out.println("Encrypted: " + encryptedMessage);
		String decryptedMessage = decrypt(encryptedMessage);
		System.out.println("Decrypted: " + decryptedMessage);

	}
	/**
	 * method to encrypt using rail fence
	 */
	public String encrypt(String text) {
		char[][] railfence = new char[key][text.length()];

		for (int i = 0; i < this.key; i++) {
			Arrays.fill(railfence[i], '\n');
		}
		boolean downdirect = false;
		int row = 0;
		int column = 0;
		for (int i = 0; i < text.length(); i ++) {
			if (row == 0 || row == key - 1) {
				downdirect = !downdirect;
			}
			railfence[row][column++] = text.charAt(i);
			if(downdirect) {
				row++;
			}else {
				row--;
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < key; i++) {
			for (int j = 0; j < text.length(); j++) {
				if(railfence[i][j] != '\n') {
					result.append(railfence[i][j]);
				}
			}
		}
		return result.toString();
	}
	/**
	 * method to decrypt using rail fence
	 */
	public String decrypt(String text) {
		char[][] railfence = new char[key][text.length()];

		for(int i = 0; i < key; i++) {
			Arrays.fill(railfence[i], '\n');
		}
		boolean downdirect = true;
		int row = 0;
		int column = 0;

		for(int i = 0; i < text.length(); i++) {
			if(row == 0) {
				downdirect = true;
			}
			if(row == key - 1) {
				downdirect = false;
			}
			railfence[row][column++] = '*';

			if(downdirect){
				row++;
			}else {
				row--;
			}
		}
		int index = 0;
		for(int i = 0; i < key; i++){
			for(int j = 0; j < text.length(); j++) {
				if(railfence[i][j] == '*' && index < text.length()) {
					railfence[i][j] = text.charAt(index++);
				}

			}
		}
		StringBuilder result = new StringBuilder();
		row = 0;
		column = 0;
		for(int i = 0; i < text.length(); i++) {
			if(row == 0) {
				downdirect = true;
			}if(row == key -1) {
				downdirect = false;
			}
			if(railfence[row][column] != '*') {
				result.append((railfence[row][column++]));
			}
			if(downdirect) {
				row++;
			}else {
				row--;
			}
		}
		return result.toString();
	}
}


