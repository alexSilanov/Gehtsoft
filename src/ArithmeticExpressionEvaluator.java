package testovoe;

import java.util.Scanner;
import java.util.regex.Pattern;

class ArithmeticExpressionEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type input: ");
        String s = scanner.nextLine().replace(" ", "");
        String subStrExpr = getSubStrInBrackets(s);
        int finalResult;
        if (subStrExpr.isEmpty()) {
            finalResult = getResultSubstr(s);
        } else {
            int result = getResultSubstr(subStrExpr);
            String newExpr = s.replace("(" + subStrExpr + ")", String.valueOf(result));
            finalResult = getResultSubstr(newExpr);
        }
        System.out.println("Output " + finalResult);
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
        System.out.println(c);
        for (int j = 0; j < c.length(); j++) {
            if (c.charAt(j) == '+' || c.charAt(j) == '-' || c.charAt(j) == '*' || c.charAt(j) == '/') {
                op = String.valueOf(c.charAt(j));
            }
        }
        return op;
    }

    public static int getResultSubstr(String subStr) {
        String op = getOperator(subStr);
        if (op.isEmpty()) {
            return Integer.parseInt(subStr);
        }
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
