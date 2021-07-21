package 리트코드.LeetCode_1492_TheKthFactorOfN;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) list.add(i);
        }

        if (list.size() >= k) return list.get(k);
        return -1;
    }
}
