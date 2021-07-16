package 프로그래머스.Programmers_카카오인턴_수식최대화;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String[] operation = {"+", "-", "*"};
    public int[][] priorities = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 1, 0}, {2, 0, 1}};
    public Long answer = Long.MIN_VALUE;

    public long solution(String expression) {
        String[] temp1 = expression.split("[^0-9]");
        List<Long> numberList = new ArrayList<>();
        for (String s : temp1) numberList.add(Long.parseLong(s));

        String[] temp2 = expression.split("[0-9]+");
        List<String> operationList = new ArrayList<>();
        for (String s : temp2) operationList.add(s);
        operationList.remove(0);

        for (int[] priority : priorities) {
            List<Long> numbers = new ArrayList<>(numberList);
            List<String> operations = new ArrayList<>(operationList);
            calculate(numbers, operations, operation[priority[0]]);
            calculate(numbers, operations, operation[priority[1]]);
            calculate(numbers, operations, operation[priority[2]]);
            answer = Math.max(answer, Math.abs(numbers.get(0)));
        }

        return answer;
    }

    public void calculate(List<Long> numbers, List<String> operations, String operation) {
        int index = 0;
        int length = operations.size();

        while (index < length) {
            if (operation.equals(operations.get(index))) {
                switch (operation) {
                    case "+":
                        numbers.set(index, numbers.get(index) + numbers.get(index + 1));
                        break;
                    case "-":
                        numbers.set(index, numbers.get(index) - numbers.get(index + 1));
                        break;
                    case "*":
                        numbers.set(index, numbers.get(index) * numbers.get(index + 1));
                        break;
                }
                numbers.remove(index + 1);
                operations.remove(index);
                index--;
                length--;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("100-200*300-500+20");
    }
}
