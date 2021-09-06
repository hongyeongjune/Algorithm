package 리트코드.LeetCode_414_ThirdMaximumNumber;

import java.util.*;

public class Solution {
    // 주어진 배열에서 세 번째로 큰 Distinct 한 정수 찾기
    // 단, Distinct 한 정수의 개수가 2이하라면 가장 큰 값을 출력한다.
    // ex) nums : [1,2,3];
    // solution) answer : 1
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        return list.size() > 2 ? list.get(2) : list.get(0);
    }
}
