package 리트코드.LeetCode_1365_HowManyNumbersAreSmallerThanTheCurrentNumber;

public class LeetCode_1365_HowManyNumbersAreSmallerThanTheCurrentNumber {
    // 주어진 배열에서 각 요소의 값보다 작은 모든 값들을 찾아서 개수를 차례대로 return 해라
    // 조건) i != j
    // ex) nums : [8,1,2,2,3];
    // solution) answer : [4,0,1,1,3];
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) answer[i]++;
            }
        }
        return answer;
    }
}
