import java.util.Scanner;

public class ArithmeticExpressionEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.replace(" ", "");


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int startBracket = i;
                int endBracket = s.indexOf(')', startBracket);
                String subStr = s.substring(startBracket + 1, endBracket);
                System.out.println(subStr);
            }
        }
    }}
  