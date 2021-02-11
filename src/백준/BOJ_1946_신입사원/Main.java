package 백준.BOJ_1946_신입사원;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];

        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            List<NewRecruits> newRecruits = new ArrayList<NewRecruits>();
            for (int j = 0; j < x; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                newRecruits.add(new NewRecruits(paper, interview));
            }

            Collections.sort(newRecruits, new Comparator<NewRecruits>() {
                @Override
                public int compare(NewRecruits o1, NewRecruits o2) {
                    return o1.paper < o2.paper ? -1 : 1;
                }
            });

            int count = newRecruits.size();
            int size = newRecruits.get(0).interview;

            for (int j = 1; j < newRecruits.size(); j++) {
                if (size < newRecruits.get(j).interview) {
                    count--;
                } else if (size > newRecruits.get(j).interview) {
                    size = newRecruits.get(j).interview;
                }
            }
            result[i] = count;
        }

        for (int i = 0; i < T; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static class NewRecruits {
        private int paper;
        private int interview;

        public NewRecruits(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }
}
