package 리트코드.LeetCode_1108_DefangingAnIPAddress;

public class LeetCode_1108_DefangingAnIPAddress {
    // 주어진 문자열에 . 이 들어가있으면 [.]으로 바꿔라
    // ex) str : 127.0.0.1
    // solution) answer : 127[.]0[.]0[.]1
    public String solution(String str) {
        return str.replace(".", "[.]");
    }
}
