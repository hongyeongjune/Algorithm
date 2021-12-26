package 프로그래머스.Programmers_피로도;

public class Solution {

    public static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        Dungeons[] fatigue = new Dungeons[dungeons.length];
        for(int i=0; i<dungeons.length; i++) {
            fatigue[i] = new Dungeons(dungeons[i][0], dungeons[i][1]);
        }

        dfs(fatigue, 0, k);

        return answer;
    }

    private void dfs(Dungeons[] fatigue, int index, int k) {
        if(index == fatigue.length) {
            int temp = k;
            int count = 0;
            for(int i=0; i<fatigue.length; i++) {
                if(temp >= fatigue[i].minFatigue) {
                    temp -= fatigue[i].useFatigue;
                    count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        for(int i=index; i<fatigue.length; i++) {
            swap(fatigue, index, i);
            dfs(fatigue, index+1, k);
            swap(fatigue, index, i);
        }
    }

    private void swap(Dungeons[] fatigue, int index, int i) {
        Dungeons temp = fatigue[index];
        fatigue[index] = fatigue[i];
        fatigue[i] = temp;
    }

    public class Dungeons {
        int minFatigue;
        int useFatigue;

        public Dungeons(int minFatigue, int useFatigue) {
            this.minFatigue = minFatigue;
            this.useFatigue = useFatigue;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(80, new int[][]{
                {80,20}, {50,40}, {30,10}
        });
    }
}
