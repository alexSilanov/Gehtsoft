import java.util.Scanner;
import java.util.regex.Matcher;
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

    public static void evaluateResult(Scanner scan) {
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
        subStr = subStr.replace(" ", "");


        Pattern multDivPattern = Pattern.compile("(\\d+)([*/])(\\d+)");
        Matcher numbersMatch = multDivPattern.matcher(subStr);
        while (numbersMatch.find()) {
            int num1 = Integer.parseInt(numbersMatch.group(1));
            int num2 = Integer.parseInt(numbersMatch.group(3));
            String op = numbersMatch.group(2);
            int res = op.equals("*") ? num1 * num2 : (num2 != 0 ? num1 / num2 : 0);
            subStr = subStr.substring(0, numbersMatch.start()) + res + subStr.substring(numbersMatch.end());
            return getResultSubstr(subStr); // рекурсивный вызов
        }

        Pattern sumDifPattern = Pattern.compile("(\\d+)([+-])(\\d+)");
        numbersMatch = sumDifPattern.matcher(subStr);
        while (numbersMatch.find()) {
            int num1 = Integer.parseInt(numbersMatch.group(1));
            int num2 = Integer.parseInt(numbersMatch.group(3));
            String op = numbersMatch.group(2);
            int res = op.equals("+") ? num1 + num2 : num1 - num2;
            subStr = subStr.substring(0, numbersMatch.start()) + res + subStr.substring(numbersMatch.end());
            return getResultSubstr(subStr);
        }

        return Integer.parseInt(subStr);
    }

}
