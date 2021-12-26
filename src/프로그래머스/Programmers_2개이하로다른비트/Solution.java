package 프로그래머스.Programmers_2개이하로다른비트;

public class Solution {
    public long[] solution(long[] numbers) {

        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            String binaryString = Long.toBinaryString(numbers[i]);
            int count = 0;
            for(int j=binaryString.length()-1; j>=0; j--) {
                if(binaryString.charAt(j) == '1') {
                    count++;
                    continue;
                }
                break;
            }

            if(count < 2) {
                answer[i] = numbers[i] + 1;
            }
            else {
                answer[i] = (long) (numbers[i] + Math.pow(2, count - 1));
            }
        }

        return answer;
    }

    public boolean isLessThanTwo(long number, int index) {
        long num = (number+index) ^ (number);
        String binaryString = Long.toBinaryString(num);
        return binaryString.length() - binaryString.replace("1","").length() <= 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new long[]{2,7});
    }
}
