package 리트코드.LeetCode_1528_ShuffleString;

public class LeetCode_1528_ShuffleString {
    // 주어진 문자열의 원래 위치는 indices 배열의 값과 같다.
    // 문자열을 재배치 하여라.
    // ex) str : tionsolu , indices : [4,5,6,7,0,1,2,3]
    // solution) answer = solution
    public String solution(String str, int[] indices) {
        char[] answer = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            answer[indices[i]] = str.charAt(i);
        }
        return String.valueOf(answer);
    }
}
