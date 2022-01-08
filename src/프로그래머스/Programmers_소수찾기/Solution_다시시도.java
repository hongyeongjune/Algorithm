package 프로그래머스.Programmers_소수찾기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_다시시도 {

    public Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, visited, new StringBuilder());
        List<Integer> list = new ArrayList<>(set);
        for(int i=0; i<list.size(); i++) {
            if(isPrime(list.get(i))) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(char[] arr, boolean[] visited, StringBuilder stringBuilder) {
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                stringBuilder.append(arr[i]);
                visited[i] = true;
                set.add(Integer.parseInt(stringBuilder.toString()));
                dfs(arr, visited, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int number) {
        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0)
                return false;
        }

        return number >= 2 ? true : false;
    }

    public static void main(String[] args) {
        Solution_다시시도 solution = new Solution_다시시도();
        solution.solution("011");
    }
}
