package 리트코드.LeetCode_442_FindAllDuplicateInAnArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> answer = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) answer.add(num);
        }

        return answer;
    }
}
