package 우아한테크코스.프로그래밍1;

public class Solution {
    public int solution(String[] grades, int[] weights, int threshold) {

        int sum = 0;

        for (int i = 0; i < grades.length; i++) {
            switch (grades[i]) {
                case "A+":
                    sum += (10 * weights[i]);
                    break;
                case "A0":
                    sum += (9 * weights[i]);
                    break;
                case "B+":
                    sum += (8 * weights[i]);
                    break;
                case "B0":
                    sum += (7 * weights[i]);
                    break;
                case "C+":
                    sum += (6 * weights[i]);
                    break;
                case "C0":
                    sum += (5 * weights[i]);
                    break;
                case "D+":
                    sum += (4 * weights[i]);
                    break;
                case "D0":
                    sum += (3 * weights[i]);
                    break;
                case "F":
                    sum += (0 * weights[i]);
                    break;
            }
        }
        return sum - threshold;
    }
}
