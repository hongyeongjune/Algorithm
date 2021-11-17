package 프로그래머스.Programmers_수식최대화;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static String[][] symbols = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"}, {"-", "*", "+"}, {"*", "+", "-"}, {"*", "-", "+"}};
    public static long answer = Long.MIN_VALUE;

    public long solution(String expression) {

        List<Long> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        String str = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                str += c;
            } else {
                numbers.add(Long.parseLong(str));
                operations.add(String.valueOf(c));
                str = "";
            }
        }
        numbers.add(Long.parseLong(str));

        for (String[] symbol : symbols) {
            List<Long> tempNumbers = new ArrayList<>(numbers);
            List<String> tempOperations = new ArrayList<>(operations);
            calculate(tempNumbers, tempOperations, symbol[0]);
            calculate(tempNumbers, tempOperations, symbol[1]);
            calculate(tempNumbers, tempOperations, symbol[2]);
            answer = Math.max(answer, Math.abs(tempNumbers.get(0)));
        }

        return answer;
    }

    public void calculate(List<Long> numbers, List<String> operations, String symbol) {
        int index = 0;
        int length = operations.size();
        while (index < length) {
            long calculateAnswer = 0;
            if (symbol.equals(operations.get(index))) {
                switch (operations.get(index)) {
                    case "+":
                        calculateAnswer += numbers.get(index) + numbers.get(index + 1);
                        break;
                    case "-":
                        calculateAnswer += numbers.get(index) - numbers.get(index + 1);
                        break;
                    case "*":
                        calculateAnswer += numbers.get(index) * numbers.get(index + 1);
                        break;
                }
                operations.remove(index);
                numbers.set(index, calculateAnswer);
                numbers.remove(index + 1);
                index--;
                length--;
            }
            index++;
        }
    }
}
