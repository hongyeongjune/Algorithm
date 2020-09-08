package 그래프.프로그래머스.순위;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Others {
    public static int solution(int n, int[][] results) {

        int answer = 0;

        List<Player> players = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            players.add(new Player(i));

        for (int[] result : results) {
            players.get(result[0]).win.add(result[1]);
            players.get(result[1]).lose.add(result[0]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {

                Player player = players.get(j);

                HashSet<Integer> win = new HashSet<>();

                for (Integer winner : player.win) {
                    for (Integer w : players.get(winner).win) {
                        win.add(w);
                    }
                }

                player.win.addAll(win);

                HashSet<Integer> lose = new HashSet<>();

                for (Integer loser : player.lose) {
                    for (Integer l : players.get(loser).lose) {
                        lose.add(l);
                    }
                }

                player.lose.addAll(lose);
            }
        }

        for (Player player : players) {

            if (player.win.size() + player.lose.size() == n - 1)
                answer++;
        }

        return answer;
    }

    public static class Player {

        int index;

        HashSet<Integer> win = new HashSet<>();
        HashSet<Integer> lose = new HashSet<>();

        public Player(int index) {
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                solution(5, new int[][]{{4, 3,}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})
        );
    }
}
