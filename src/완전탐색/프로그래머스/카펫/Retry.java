package 완전탐색.프로그래머스.카펫;

public class Retry {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int index = 1;

        while (index <= yellow) {
            if (yellow % index == 0) {
                int temp = yellow / index;
                if ((index + 2) * (temp + 2) - yellow == brown) {

                    if (index + 2 > temp + 2) {
                        answer[0] = index + 2;
                        answer[1] = temp + 2;
                    } else {
                        answer[1] = index + 2;
                        answer[0] = temp + 2;
                    }

                    return answer;
                }
            }
            index++;
        }
        return answer;
    }

}
