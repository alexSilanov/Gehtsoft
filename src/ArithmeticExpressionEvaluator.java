import java.util.Scanner;
import java.util.regex.Pattern;

public class ArithmeticExpressionEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type ev:");
        String s = scanner.nextLine();

        String subStrExpr = getSubStrInBrackets(s);
        String operator = getOperator(subStrExpr);
        int result = getResultSubstr(subStrExpr);
        System.out.println("Result: " + result);
    }

    public static String getSubStrInBrackets(String s) {
        String str = s.replace(" ", "");
        int startBracket = str.indexOf('(');
        int endBracket = str.indexOf(')', startBracket);

        if (startBracket != -1 && endBracket != -1 && endBracket > startBracket) {
            return str.substring(startBracket + 1, endBracket);
        }
        return "";
    }

    public static String getOperator(String c) {
        String op = "";
        c = c.replace(" ", "");
        for (int j = 0; j < c.length(); j++) {
            if (c.charAt(j) == '+' || c.charAt(j) == '-' || c.charAt(j) == '*' || c.charAt(j) == '/') {
                op = String.valueOf(c.charAt(j));
            }
        }
        return op;
    }

    public static int getResultSubstr(String subStr) {
        String op = getOperator(subStr);
        String[] numbers = subStr.split(Pattern.quote(op));

        int num1 = Integer.parseInt(numbers[0].trim());
        int num2 = Integer.parseInt(numbers[1].trim());

        return switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num2 != 0 ? num1 / num2 : 0;
            default -> throw new IllegalStateException("Unknown operator");
        };
    }
}
