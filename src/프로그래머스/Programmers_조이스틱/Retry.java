package 프로그래머스.Programmers_조이스틱;

public class Retry {
    public static int solution(String name) {
        int answer = 0;
        int[] move = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        for (char c : name.toCharArray()) {
            answer += move[c - 'A'];
        }

        int length = name.length();
        int min = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            min = Math.min(min, i + length - next + Math.min(i, length - next));
        }
        return answer;
    }

    public static void main(String[] args) {
        solution("JAZ");
    }
}
