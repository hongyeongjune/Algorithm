package 우아한테크코스.프로그래밍3;

public class Solution {
    public int solution(int money, String[] expected, String[] actual) {
        int answer = -1;
        int batting = 100;
        for (int i = 0; i < expected.length; i++) {

            if (money <= 0) return 0;

            if (!expected[i].equals(actual[i])) {
                money -= batting;
                if (money < batting * 2) {
                    batting = money;
                } else batting *= 2;
            } else {
                money += batting;
                batting = 100;
            }
        }
        return answer = money;
    }
}
