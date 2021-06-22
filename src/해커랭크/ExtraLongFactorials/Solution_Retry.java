package 해커랭크.ExtraLongFactorials;

import java.math.BigInteger;

public class Solution_Retry {
    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(bigInteger);
    }
}
