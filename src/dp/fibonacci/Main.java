package dp.fibonacci;

public class Main {

    private static int[] d;

    public static void main(String[] args) {
        d = new int[100];

        System.out.println(dp(30));
    }

    /**
     * 재귀함수 피보나치
     * @param x
     * @return
     */
    private static int recursion(int x) {
        if(x == 1) return 1;
        if(x == 2) return 1;

        return dp(x - 1) + dp(x - 2);
    }

    /**
     * dp 피보나치
     * @param x
     * @return
     */
    private static int dp(int x) {
        if(x == 1) return 1;
        if(x == 2) return 1;
        if(d[x] != 0) return d[x];
        return d[x] = dp(x - 1) + dp(x - 2);
    }
}
