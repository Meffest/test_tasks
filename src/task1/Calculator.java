package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Calculator {
    private static Double calculate(String s) {
        LinkedList<Double> digits = new LinkedList<>();
        LinkedList<Character> operands = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(')
                operands.add('(');
            else if (c == ')') {
                while (operands.getLast() != '(') {
                    processOperator(digits, operands.removeLast());
                }
                operands.removeLast();
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '.') {
                while (!operands.isEmpty() && priority(operands.getLast()) >= priority(c)) {
                    processOperator(digits, operands.removeLast());
                }
                operands.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    operand += s.charAt(i++);
                }
                --i;
                digits.add(Double.parseDouble(operand));
            }
        }

        while (!operands.isEmpty()) {
            processOperator(digits, operands.removeLast());
        }
        double d = digits.get(0);
        return roundDouble(d, 4);
    }

    private static int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/' || operator == '.') {
            return 2;
        } else return -1;
    }

    private static void processOperator(LinkedList<Double> digits, char operator) {
        double right = digits.removeLast();
        double left = digits.removeLast();

        if (operator == '+') {
            digits.add(left + right);
        } else if (operator == '-') {
            digits.add(left - right);
        } else if (operator == '*') {
            digits.add(left * right);
        } else if (operator == '/') {
            digits.add(left / right);
        } else if (operator == '.') {
            digits.add(left + right / (Math.pow(10, precision((int) right))));
        }
    }

    private static double roundDouble(Double d, int precisionDecimal) {
        precisionDecimal = (int) Math.pow(10, precisionDecimal);
        d = d * precisionDecimal;
        int i = (int) Math.round(d);
        return (double) i / precisionDecimal;
    }

    private static int precision(int i) {
        int precise = 1;
        while (i / 10 > 0) {
            i = i / 10;
            precise++;
        }
        return precise;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        System.out.println(calculate(s));

    }
}
