import java.util.Scanner;
public class AutokeyCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key: ");
        String key = scanner.nextLine(); 
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        String ciphertext = encrypt(plaintext, key);
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Encrypted: " + ciphertext);
        System.out.println("Decrypted: " + decryptedText);
        scanner.close();
    }
    public static String encrypt(String text, String key) {
        String adjustedKey = key.toUpperCase() + text.replaceAll("\\s+", "").toUpperCase();
        StringBuilder ciphertext = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue; 
            ciphertext.append((char) ((c + adjustedKey.charAt(j) - 2 * 'A') % 26 + 'A'));
            j++;
        }
        return ciphertext.toString();
    }
    public static String decrypt(String text, String key) {
        StringBuilder plaintext = new StringBuilder();
        StringBuilder tempKey = new StringBuilder(key.toUpperCase());
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char p = (char) ((c - tempKey.charAt(i) + 26) % 26 + 'A');
            plaintext.append(p);
            tempKey.append(p); 
        }
        return plaintext.toString();
    }
}
