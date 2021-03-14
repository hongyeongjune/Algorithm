package 해커랭크.Abbreviation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {

                if (j > 0 && dp[i - 1][j - 1] && isEqual(a.charAt(i - 1), b.charAt(j - 1)))
                    dp[i][j] = true;
                if (Character.isLowerCase(a.charAt(i - 1)) && dp[i - 1][j])
                    dp[i][j] = true;
            }
        }

        return dp[a.length()][b.length()] ? "YES" : "NO";
    }

    private static boolean isEqual(char a, char b) {
        return a == b || Character.toUpperCase(a) == b;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
