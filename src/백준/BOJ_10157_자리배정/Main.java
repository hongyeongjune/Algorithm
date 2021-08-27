package 백준.BOJ_10157_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.print(0);
            return;
        }

        int[][] concertHall = new int[C + 1][R + 1];

        int x = 1, y = 1;
        int minX = 1, minY = 1;
        int maxX = C, maxY = R;
        int waitingNumber = 1;
        while (minX <= maxX && minY <= maxY) {

            for (int i = minY; i <= maxY; i++) {
                concertHall[minX][i] = waitingNumber++;
                if (concertHall[minX][i] == K) {
                    System.out.print(minX + " " + i);
                    return;
                }
            }

            for (int i = minX + 1; i <= maxX; i++) {
                concertHall[i][maxY] = waitingNumber++;
                if (concertHall[i][maxY] == K) {
                    System.out.print(i + " " + maxY);
                    return;
                }
            }

            if (minX < maxX && minY < maxY) {
                for (int i = maxY - 1; i > minY; i--) {
                    concertHall[maxX][i] = waitingNumber++;
                    if (concertHall[maxX][i] == K) {
                        System.out.print(maxX + " " + i);
                        return;
                    }
                }

                for (int i = maxX; i > minX; i--) {
                    concertHall[i][minY] = waitingNumber++;
                    if (concertHall[i][minY] == K) {
                        System.out.print(i + " " + minY);
                        return;
                    }
                }
            }
            minX++;
            minY++;
            maxX--;
            maxY--;
        }
    }
}
