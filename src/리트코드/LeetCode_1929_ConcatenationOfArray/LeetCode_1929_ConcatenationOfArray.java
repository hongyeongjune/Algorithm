package 리트코드.LeetCode_1929_ConcatenationOfArray;

public class LeetCode_1929_ConcatenationOfArray {

    // 주어진 배열을 똑같이 복사하여 만드시오.
    // ex) nums : [1,2,3,4];
    // solution) answer : [1,2,3,4,1,2,3,4];
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[i];
            answer[i + nums.length] = nums[i];
        }
        return answer;
    }

}
