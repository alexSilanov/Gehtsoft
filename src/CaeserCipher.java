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

    public static void startEncrypt(Scanner scanner) {
        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();
        scanner.nextLine();

        String encrypted = encrypt(text, shift);
        System.out.println("Result: " + encrypted);
    }

    public static void startDecrypt(Scanner scanner) {
        System.out.print("Enter text to decrypt: ");
        String text = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();
        scanner.nextLine();

        String decrypted = decrypt(text, shift);
        System.out.println("Result: " + decrypted);
    }

    public static String encrypt(String input, int shift) {
        char[] latAlphabetSmall = {
                'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        char[] latAlphabetUpper = {
                'A','B','C','D','E','F','G','H','I','J','K','L','M',
                'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
        };
        char[] rusAlphabetSmall = {
                'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м',
                'н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ',
                'ъ','ы','ь','э','ю','я'
        };
        char[] rusAlphabetUpper = {
                'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М',
                'Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ',
                'Ъ','Ы','Ь','Э','Ю','Я'
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            char[] alphabet = null;

            if (contains(ch, latAlphabetSmall)) {
                alphabet = latAlphabetSmall;
            } else if (contains(ch, latAlphabetUpper)) {
                alphabet = latAlphabetUpper;
            } else if (contains(ch, rusAlphabetSmall)) {
                alphabet = rusAlphabetSmall;
            } else if (contains(ch, rusAlphabetUpper)) {
                alphabet = rusAlphabetUpper;
            }

            if (alphabet != null) {
                int len = alphabet.length;
                for (int j = 0; j < len; j++) {
                    if (alphabet[j] == ch) {
                        result.append(alphabet[(j + shift + len) % len]);
                    }
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private static boolean contains(char ch, char[] alphabet) {
        for (char c : alphabet) {
            if (c == ch) return true;
        }
        return false;
    }


    public static String decrypt(String input, int shift) {
        return encrypt(input, -shift);
    }
}
