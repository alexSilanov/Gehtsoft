import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String greeting = "Welcome to Gehtsoft Technical Assessment\nPlease choose an option:\n1. Caesar Cipher Encryption\n" +
                "2. Caesar Cipher Decryption  \n" +
                "3. Arithmetic Expression Evaluation\n" +
                "4. Exit\n";
        System.out.println(greeting);
        System.out.println("");
        int chosedOption = scanner.nextInt();
        scanner.nextLine();

        switch (chosedOption) {
            case 1 -> CaeserCipher.startEncrypt(scanner);
            case 2 -> CaeserCipher.startDecrypt(scanner);
            case 3 -> ArithmeticExpressionEvaluator.evaluateResult(scanner);
            case 4 -> System.exit(0);

        }
    }
}