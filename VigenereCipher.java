import java.util.Scanner;
public class VigenereCipher {
    public static String encrypt(String plaintext, String key) {
        plaintext = plaintext.toUpperCase(); 
        key = key.toUpperCase();
        StringBuilder ciphertext = new StringBuilder();

        // Repeat the key until its length matches the plaintext
        StringBuilder repeatedKey = new StringBuilder(key);
        while (repeatedKey.length() < plaintext.length()) {
            repeatedKey.append(key);
        }
        repeatedKey.setLength(plaintext.length()); // Trim excess characters if necessary

        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char encryptedChar = (char)((c + repeatedKey.charAt(i) - 2 * 'A') % 26 + 'A');
                ciphertext.append(encryptedChar);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();
        StringBuilder plaintext = new StringBuilder();

        // Repeat the key until its length matches the ciphertext
        StringBuilder repeatedKey = new StringBuilder(key);
        while (repeatedKey.length() < ciphertext.length()) {
            repeatedKey.append(key);
        }
        repeatedKey.setLength(ciphertext.length()); // Trim excess characters if necessary

        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char decryptedChar = (char)((c - repeatedKey.charAt(i) + 26) % 26 + 'A');
                plaintext.append(decryptedChar);
            }
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted: " + encryptedText);

        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted: " + decryptedText);

        scanner.close();
    }
}
