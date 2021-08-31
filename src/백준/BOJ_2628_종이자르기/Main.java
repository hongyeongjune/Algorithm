package 백준.BOJ_2628_종이자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> width = new ArrayList<>();
        List<Integer> height = new ArrayList<>();
        width.add(Integer.parseInt(st.nextToken()));
        height.add(Integer.parseInt(st.nextToken()));

        int count = Integer.parseInt(br.readLine());

        int[][] lines = new int[count][2];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] line : lines) {
            if (line[0] == 0) {
                height.add(line[1]);
            } else width.add(line[1]);
        }

        width.add(0);
        height.add(0);
        Collections.sort(width);
        Collections.sort(height);

        int answer = 0;

        for (int i = 1; i < width.size(); i++) {
            for (int j = 1; j < height.size(); j++) {
                answer = Math.max(answer, (width.get(i) - width.get(i - 1)) * (height.get(j) - height.get(j - 1)));
            }
        }

        System.out.println(answer);
    }
}
