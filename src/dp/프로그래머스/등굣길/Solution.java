package dp.프로그래머스.등굣길;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] road = new int[n][m];
        for(int i=0; i<puddles.length; i++) {
            road[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(road[i][j] != -1) {
                    if (i == 0 && j != 0) {
                        if(road[i][j-1] != -1)
                            road[i][j] = road[i][j - 1] + 1;
                    } else if (j == 0 && i != 0) {
                        if(road[i-1][j] != -1)
                            road[i][j] = road[i - 1][j] + 1;
                    } else if (i != 0 && j != 0) {
                        if(road[i-1][j] != -1 && road[i][j-1] != -1)
                            road[i][j] = Math.min(road[i - 1][j] + 1, road[i][j - 1] + 1);
                        else if(road[i-1][j] != -1 && road[i][j-1] == -1)
                            road[i][j] = road[i-1][j]+1;
                        else if(road[i-1][j] == -1 && road[i][j-1] != -1)
                            road[i][j] = road[i][j-1]+1;
                    }
                }
            }
        }
        return answer = (Math.min(road[n-2][m-1], road[n-1][m-2]))%1000000007;
    }
}
