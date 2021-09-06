package 리트코드.LeetCode_1480_RunningSumOf1dArray;

public class LeetCode_1480_RunningSumOf1dArray {
    //배열에서 각 인덱스의 위치의 합을 값으로하는 배열을 만들어라
    // ex) nums : [1,2,3,4];
    // solution) answer : [1, 1+2, 1+2+3, 1+2+3+4];
    // solution) answer : [1,3,6,10];
    public int[] runningSum(int[] nums) {
        int[] memoization = new int[nums.length];
        memoization[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memoization[i] = memoization[i - 1] + nums[i];
        }
        return memoization;
    }
}
