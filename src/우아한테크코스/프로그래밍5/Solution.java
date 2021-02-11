package 우아한테크코스.프로그래밍5;

public class Solution {
    public String solution(String penter, String pexit, String pescape, String data) {
        String answer = penter;
        int length = penter.length();
        for (int i = 0; i < data.length(); i += length) {
            if (data.substring(i, i + length).equals(penter)) answer += pescape;
            if (data.substring(i, i + length).equals(pexit)) answer += pescape;
            if (data.substring(i, i + length).equals(pescape)) answer += pescape;
            answer += data.substring(i, i + length);
        }

        return answer + pexit;
    }

}