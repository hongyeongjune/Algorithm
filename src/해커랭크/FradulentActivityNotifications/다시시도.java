package 해커랭크.FradulentActivityNotifications;

public class 다시시도 {
    static int activityNotifications(int[] expenditure, int d) {

        int answer = 0;

        //expenditure 에서 가장 큰 값이 200
        int[] count = new int[201];

        // 처음 d까지 만큼 개수를 채워준다.
        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            // 중앙 값 찾기
            double center = findCenter(count, d);

            if (expenditure[i] >= 2 * center) answer++;

            //맨 처음꺼 개수 빼기
            count[expenditure[i - d]]--;
            //마지막 꺼 개수 추가
            count[expenditure[i]]++;
        }

        return answer;
    }

    private static double findCenter(int[] count, int d) {

        int median = 0;
        double result = 0;

        //홀수 일 경우
        if (d % 2 != 0) {
            for (int i = 0; i < count.length; i++) {
                //개수를 더한다.
                median += count[i];
                // d의 절반만큼의 개수가 나온다면
                if (median > (d / 2)) {
                    // 현재 인덱스가 중앙 값
                    return result = i;
                }
            }
        }
        // 짝수면
        else {
            int first = 0;
            int second = 0;

            for (int i = 0; i < count.length; i++) {

                median += count[i];
                // d의 절반만큼 개수가 나온다면 현재 인덱스값 저장
                if (first == 0 && median >= d / 2) first = i;
                // d의 절반보다 1 큰 개수가 나온다면 현재 인덱스 값 저장
                if (second == 0 && median >= d / 2 + 1) {
                    second = i;
                    break;
                }
            }
            // 그 둘의 중간이 중앙값
            return result = (first + second) / 2.0;
        }

        return result;
    }
}
