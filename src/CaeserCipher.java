import java.util.Scanner;

public class CaeserCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input text from the keyboard
        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine().toLowerCase(); // convert to lowercase to match alphabet

        // Input shift
        System.out.print("Enter shift: ");
        int shift = scanner.nextInt();

        String encrypted = encrypt(text, shift);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted: " + decrypted);
    }

    public static String encrypt(String input, int shift) {
        char[] latAlphabet = {
                'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };

        char[] rusAlphabet = {
                'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м',
                'н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ',
                'ъ','ы','ь','э','ю','я'
        };

        char[] alphabet;
        StringBuilder result = new StringBuilder();

        // Determine if the text is in Latin or Cyrillic
        if (Character.UnicodeBlock.of(input.charAt(0)) == Character.UnicodeBlock.BASIC_LATIN) {
            alphabet = latAlphabet;
        } else {
            alphabet = rusAlphabet;
        }

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (input.charAt(i) == alphabet[j]) {
                    if (shift < 0) {
                        result.append(alphabet[(j + shift + alphabet.length) % alphabet.length]);
                    } else {
                        result.append(alphabet[(j + shift) % alphabet.length]);
                    }
                    break;
                }
            }
        }

        return result.toString();
    }

    public static String decrypt(String input, int shift) {
        return encrypt(input, -shift);
    }
}
