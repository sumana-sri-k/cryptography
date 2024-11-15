import java.io.*;
import java.util.*;
public class Main{
  public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public static String encrypt(String plaintext, int shiftKey) {
    plaintext = plaintext.toLowerCase();
    StringBuilder ciphertext = new StringBuilder();
    for (int i = 0; i < plaintext.length(); i++) {
      int charPosition = ALPHABET.indexOf(plaintext.charAt(i));
      int encryptedCharPos = (shiftKey + charPosition) % 26;
      char encryptedChar = Character.toUpperCase(ALPHABET.charAt(encryptedCharPos));
      ciphertext.append(encryptedChar);
    }
    return ciphertext.toString();
  }

  public static String decrypt(String ciphertext, int shiftKey) {
    ciphertext = ciphertext.toLowerCase();
    StringBuilder decryptedMessage = new StringBuilder();
    for (int i = 0; i < ciphertext.length(); i++) {
      int charPosition = ALPHABET.indexOf(Character.toLowerCase(ciphertext.charAt(i)));
      int decryptedCharPos = (charPosition - shiftKey) % 26;
      if (decryptedCharPos < 0) {
        decryptedCharPos = ALPHABET.length() + decryptedCharPos;
      }
      char decryptedChar = Character.toUpperCase(ALPHABET.charAt(decryptedCharPos));
      decryptedMessage.append(decryptedChar);
    }
    return decryptedMessage.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String plaintext = "";
    int shiftKey = 0;

    // Input for encryption
    System.out.print("Enter the String for Encryption:");
    plaintext = scanner.next();

    System.out.println("\nEnter Shift Key:");
    shiftKey = scanner.nextInt();

    // Encrypt the message
    String ciphertext = encrypt(plaintext, shiftKey);
    System.out.println("\nEncrypted Message: " + ciphertext);

    // Decrypt the encrypted message
    String decryptedMessage = decrypt(ciphertext, shiftKey);
    System.out.println("\nDecrypted Message: " + decryptedMessage);

  }
}
