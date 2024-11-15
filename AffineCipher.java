import java.util.Scanner; 
public class Main {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

    public static String encrypt(String plaintext, int k1, int k2) {
        plaintext = plaintext.toLowerCase();
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isLetter(currentChar)) {
                int charPosition = ALPHABET.indexOf(currentChar);
                int encryptedCharPos = (k1 * charPosition + k2) % 26;
                char encryptedChar = Character.toUpperCase(ALPHABET.charAt(encryptedCharPos));
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int k1, int k2) {
        ciphertext = ciphertext.toLowerCase();
        int modInverseK1 = modInverse(k1, 26);
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                int charPosition = ALPHABET.indexOf(currentChar);
                int decryptedCharPos = (modInverseK1 * (charPosition - k2 + 26)) % 26;
                char decryptedChar = Character.toUpperCase(ALPHABET.charAt(decryptedCharPos));
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(currentChar);
            }
        }
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plaintext = "";
        int k1, k2;

        // Input for encryption
        System.out.print("Enter the String for Encryption:");
        plaintext = scanner.nextLine();

        System.out.println("\nEnter Key Values (k1 k2):");
        k1 = scanner.nextInt();
        k2 = scanner.nextInt();

        // Check if k1 is coprime with 26
        if (gcd(k1, 26) != 1) {
            System.out.println("Invalid key values. Choose a different key.");
            return;
        }

        // Encrypt the message
        String ciphertext = encrypt(plaintext, k1, k2);
        System.out.println("\nEncrypted Message: " + ciphertext);

        // Decrypt the encrypted message
        String decryptedMessage = decrypt(ciphertext, k1, k2);
        System.out.println("\nDecrypted Message: " + decryptedMessage);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);}}
