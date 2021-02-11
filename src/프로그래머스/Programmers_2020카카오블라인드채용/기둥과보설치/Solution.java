package 프로그래머스.Programmers_2020카카오블라인드채용.기둥과보설치;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < build_frame.length; i++) {

            if (build_frame[i][2] == 0
                    && build_frame[i][3] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(build_frame[i][0]);
                temp.add(build_frame[i][1]);
                temp.add(build_frame[i][0]);
            }

        }
        return answer;
    }
}
