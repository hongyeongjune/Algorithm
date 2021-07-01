package 프로그래머스.Programmers_다단계칫솔판매;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // 연결된 맵
        Map<String, String> map = new HashMap<>();
        // 자신의 위치를 기억하는 맵
        Map<String, Integer> index = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            //시작 노드
            String key = seller[i];
            //시작 노드의 가격
            int price = 100 * amount[i];
            //연결된 노드가 끝날때 까지 반복
            while (!key.equals("-")) {
                //다음 가격 구하기
                int temp = (int) (price * 0.1);
                //다음 가격이 1보다 작으면 자신이 다 가지고 반복문 종료
                if (temp < 1) {
                    answer[index.get(key)] += price;
                    break;
                }
                //현재 가격에서 다음 가격 뺀 값을 가진다.
                answer[index.get(key)] += (price - temp);

                //연결된 노드 값 변경
                key = map.get(key);
                //가격 변경
                price = temp;
            }
        }
        return answer;
    }
}
