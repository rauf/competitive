package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskD {

    private int mod = (int) 1e8;

    private int K1;
    private int K2;

    private int ways(int[][][][] dp, int n1, int n2, int k1, int k2) {

        if (n1 <= 0) {
            if (n2 > k2) return 0;
            return 1;
        }

        if (n2 <= 0) {
            if (n1 > k1) return 0;
            return 1;
        }

        if (dp[n1][n2][k1][k2] != -1) return dp[n1][n2][k1][k2];

        int way = 0;

        if (k1 > 0) way = ways(dp, n1 - 1, n2, k1 - 1, K2) % mod;
        if (k2 > 0) way = (way % mod + ways(dp, n1, n2 - 1, K1, k2 - 1) % mod) % mod;
        return dp[n1][n2][k1][k2] = way;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int k1 = in.nextInt();
        int k2 = in.nextInt();

        K1 = k1;
        K2 = k2;

        int[][][][] dp = new int[n1 + 1][n2 + 1][k1 + 1][k2 + 1];

        for (int[][][] a: dp) {
            for (int[][] b: a) {
                for (int[] c: b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        out.println(ways(dp, n1, n2, k1, k2));
    }
}
