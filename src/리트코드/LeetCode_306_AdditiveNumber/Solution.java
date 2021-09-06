package 리트코드.LeetCode_306_AdditiveNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, new ArrayList<>(), 0);
    }

    private boolean dfs(String num, List<Integer> list, int index) {

        // list 의 size 가 2 가 넘어가면 true -> list 에 순서대로 담기기 때문
        if (index == num.length()) {
            return list.size() > 2;
        }

        int number = 0;

        for (int i = index; i < num.length(); i++) {

            if (i != index && num.charAt(index) == '0')
                break;

            number = (number * 10) + (num.charAt(i) - '0');

            if (list.size() < 2 || list.get(list.size() - 1) + list.get(list.size() - 2) == number) {
                list.add(number);
                if (dfs(num, list, i + 1))
                    return true;
                list.remove(list.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isAdditiveNumber("199100199");
    }
}
