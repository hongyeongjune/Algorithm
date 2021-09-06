package 리트코드.LeetCode_859_BuddyStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_859_BuddyStrings {
    // 두 개의 문자열이 있다.
    // 문자열 s 에서 딱 두 개의 문자만 골라서 swap 했을 경우 goal 과 같은 문자열이 될 수 있는지 판단하여라
    // ex) s : abcd , goal : bacd
    // solution) index 0 과 index 1의 문자를 바꿀 수 있다 => true
    // ex) s : abab , goal : abab
    // solution) index 0과 index 2의 문자를 바꿀 수 있다. => true
    public boolean solution(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) set.add(c);
            return set.size() < s.length();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) list.add(i);
        }
        return list.size() == 2 && s.charAt(list.get(0)) == goal.charAt(list.get(1)) && s.charAt(list.get(1)) == goal.charAt(list.get(0));
    }
}
