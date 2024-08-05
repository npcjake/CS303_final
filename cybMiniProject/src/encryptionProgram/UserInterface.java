package encryptionProgram;

import java.util.Scanner;

public class UserInterface {
	private static final Scanner scan = new Scanner(System.in);
	private static String text;
	private static int key;
	private static int userinput;
	private static String encryptedtext;
	private static String decryptedtext;

	public UserInterface() {

	}
	
	/**
	 * Method to get user information and choose the appropriate cipher encryption method
	 */
	public void userPrompt() {
		System.out.println("Symmetric[1] or Asymmetric[2] encryption?");
		userinput = scan.nextInt();
		if(userinput == 1) {
			System.out.println("Traditional[1] or Modern[2] cipher?");
			userinput = scan.nextInt();
			if(userinput == 1) {
				System.out.println("Caeser[1] or Autokey[2] or Rail Fence[3] cipher?");
				userinput = scan.nextInt();
				if(userinput == 1) {
					Caeser();
				}else if(userinput == 2) {
					AutoKey();
				}else if(userinput == 3) {
					RailFenceCipher();
				}
			}else if(userinput == 2) {
				System.out.println("AES[1] or DES[2] cipher?");
				userinput = scan.nextInt();
				if(userinput == 1) {
					AES();
				}else if(userinput == 2) {
					DES();
				}
			}
		}else if(userinput == 2){
			System.out.println("RSA[1] algorithmn?");
			userinput = scan.nextInt();
			if(userinput == 1) {
				RSA();
			}

		}
	}
	/**
	 * Caeser cipher
	 */
	public void Caeser() {

	}
	/**
	 * Autokey cipher
	 */
	public void AutoKey() {

	}
	/**
	 * Rail fence cipher
	 */
	public void RailFenceCipher() {
		text = getusertext();
		key = getuserint();
		RailFence railfence = new RailFence(text, key);
		encryptedtext = railfence.encrypt();
		RailFence railfence2 = new RailFence(encryptedtext, key);
		decryptedtext = railfence2.decrypt();
		System.out.println(encryptedtext + '\n' + decryptedtext);

	}
	/**
	 * AES cipher
	 */
	public void AES() {

	}
	/**
	 * DES cipher
	 */
	public  void DES() {

	}
	/**
	 * RSA cipher
	 */
	public  void RSA() {

	}
	/**
	 * Method to get a users text input
	 */
	public String getusertext() {
		System.out.println("Input text");
		scan.nextLine();
		text = scan.nextLine();
		return text;
	}
	/**
	 * Method to get a users integer input
	 */
	public static int getuserint() {
		System.out.println("Input key");
		key = scan.nextInt();
		return key;
	}

}