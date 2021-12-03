package 리트코드.LeetCode_930_BinarySubarraysWithSum;

public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int sum = 0;
        int answer = 0;
        int[] count = new int[nums.length+1];
        // 처음으로 goal 이 되는 지점을 판단하기 위해 0을 1로 설정
        count[0] = 1;

        // sum - goal 의 값은 1부터 1씩 증가하기 시작함
        // 따라서, 가장 처음 나오는 1의 위치부터 그 뒤의 0 까지의 개수를 더하면 된다
        // 예를들어, 1 0 0 1 0 0 0 1 ... 값이 있다고 가정하면,
        // count 배열의 값은 1 3 4 1 ... 이 될 것이다.
        // sum 이 3 인 지점에서 goal 이 2라면,
        // 맨 처음 나오는 1의 위치부터 그 다음 1의 위치까지 의 개수가 현재 나올 수 있는 서브 어레이의 개수다.
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum >= goal) {
                answer += count[sum - goal];
            }
            count[sum]++;
        }
        return answer;
    }
}
