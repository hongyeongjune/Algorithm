package 리트코드.LeetCode_1909_RemoveOneElementToMakeTheArrayStrictlyIncreasing;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1909_RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    // 주어진 배열에서 하나의 숫자만 뺏을 때 오름차순이 되는지 확인하여라
    // ex) nums : [1,2,10,4,7];
    // solution) answer : [1,2,4,7];
    public boolean solution(int[] nums) {
        boolean answer = false;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.remove(i);
            if (isIncreasing(temp)) {
                answer = true;
            }
        }
        return answer;
    }

    public boolean isIncreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (!(list.get(i - 1) < list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
