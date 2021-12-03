package 리트코드.LeetCode_978_LongestTurbulentSubarray;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {

        boolean flag = false;
        int answer = 1;
        int count = 1;

        for(int i=1; i<arr.length; i++) {
            if(!flag) {
                if(arr[i-1] > arr[i]) {
                    count++;
                    flag = true;
                }
                else if(arr[i-1] < arr[i]) {
                    count = 2;
                }
                else count = 1;
            }
            else {
                if(arr[i-1] < arr[i]) {
                    count++;
                    flag = false;
                }
                else if(arr[i-1] > arr[i]) {
                    count = 2;
                }
                else count = 1;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
