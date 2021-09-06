package 리트코드.LeetCode_1342_NumberOfStepsToReduceANumberToZero;

public class LeetCode_1342_NumberOfStepsToReduceANumberToZero {
    //주어진 숫자가 0이 될 때까지 짝수면 /2 홀수면 -1을 하고 몇번인지 제출하라
    // ex) num : 13
    // solution) answer : 6
    public int solution(int num) {
        int answer = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            answer++;
        }
        return answer;
    }
}
