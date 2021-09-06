package 리트코드.LeetCode_1470_ShuffleTheArray;

public class LeetCode_1470_ShuffleTheArray {
    // 배열 nums 와 nums 배열 길이의 절반인 n 이 주어졌을 때, 배열을 절반으로 나눠 첫 번째 요소부터 차례대로 섞어라.
    // ex) nums : [1,2,3,4,5,6] , n : 3
    // solution) answer : [1,4,2,5,3,6]
    public int[] solution(int[] nums, int n) {
        int[] answer = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            answer[index++] = nums[i];
            answer[index++] = nums[i + n];
        }
        return answer;
    }
}
