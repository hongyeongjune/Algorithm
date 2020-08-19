package greedy.프로그래머스.조이스틱;

public class Solution {
    public int solution(String name) {
        int answer = 0;
        boolean isA = false;
        if(name.length() == 1) {
            if (name.charAt(0) >= 'N') {
                answer += 'Z' - name.charAt(0) + 1;
            } else {
                answer += name.charAt(0) - 'A';
            }
        }

        else {
            for (int i = 0; i < name.length(); i++) {
                if(name.charAt(i) == 'A') isA = true;
                if (name.charAt(i) >= 'N') {
                    answer += 'Z' - name.charAt(i) + 1;
                } else {
                    answer += name.charAt(i) - 'A';
                }
            }
        }

        int right = name.length()-1;
        int left = 0;
        int index = 0;
        int endIndex = 0;
        for(int i=1; i<name.length(); i++) {
            if(name.charAt(i) == 'A') {
                index = i;
                endIndex = i+1;
                while (endIndex < name.length() && name.charAt(endIndex) == 'A') {
                    endIndex++;
                }
                break;
            }
        }

        left = (index-1)*2+ 1 + name.length()-1-endIndex;


        if(!isA) {
            answer += right;
        }
        else if(right >= left) {
            answer += left;
        } else if(right < left) {
            answer += right;
        }

        return answer;
    }
}
