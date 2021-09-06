package 리트코드.LeetCode_1920_BuildArrayFromPermutation;

public class LeetCode_1920_BuildArrayFromPermutation {
    //배열의 값을 인덱스로하는 새로운 배열을 작성하여 return 하여라.
    // ex) nums : [0,3,2,1];
    // solution) answer : [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]]];
    //           answer : [0, 1, 2, 3]
    public int[] buildArray(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[nums[i]];
        }

        return answer;
    }
}
