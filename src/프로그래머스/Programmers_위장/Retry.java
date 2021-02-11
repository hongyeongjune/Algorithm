package 프로그래머스.Programmers_위장;

import java.util.HashMap;
import java.util.Iterator;

public class Retry {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] c : clothes) {
            if (hashMap.get(c[1]) != null) {
                hashMap.put(c[1], hashMap.get(c[1]) + 1);
            } else hashMap.put(c[1], 1);
        }

        System.out.println(hashMap);
        Iterator<Integer> iterator = hashMap.values().iterator();

        while (iterator.hasNext()) {
            int temp = iterator.next();
            answer *= (temp + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        solution(
                new String[][]{
                        {"yellow_hat", "headgear"},
                        {"blue_sunglasses", "eyewear"},
                        {"green_turban", "headgear"}
                }
        );
    }

}
