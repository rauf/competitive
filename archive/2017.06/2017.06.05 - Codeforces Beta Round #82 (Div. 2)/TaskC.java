package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {

/*
    private int maxTugriks(int[][] a, int[][] dp, int i, int dough) {

        if (i < 0) return 0;
        if (dough < 0) return Integer.MIN_VALUE;
        if (dough == 0) return 0;

        //if (dp[i][dough] != -1) return dp[i][dough];      //giving WA as state does not only depend on i and dough

        if (a[i][0] < a[i][1])      // ingredient less than required, skip the current stuffing
            return dp[i][dough] = maxTugriks(a, dp, i - 1, dough);

        int x = 0;
        boolean back = false;

        if (a[i][0] >= a[i][1] && dough >= a[i][2]) {   // can use this stuffing
            a[i][0] -= a[i][1];
            back = true;
            x = a[i][3] + maxTugriks(a, dp, i, dough - a[i][2]);
        }

        if (back)
            a[i][0] += a[i][1];     //backtrack

        final int y = Math.max(x, maxTugriks(a, dp, i - 1, dough));   //leave that stuffing and try next.

        return dp[i][dough] = Math.max(y, d0 + maxTugriks(a, dp, i, dough - c0));   // create bun without any stuffing.
    }*/


    private int maxTugriks(int[][] a, int[][][] dp, int i, int dough, int left) {

        // pass the currently available stuffing as a parameter so we do not have to modify the array.

        if (i < 0) return 0;
        if (dough < 0 || left < 0) return Integer.MIN_VALUE;

        if (dp[i][dough][left] != -1) return dp[i][dough][left];

        return dp[i][dough][left] = Math.max(maxTugriks(a, dp, i - 1, dough, i == 0 ? 0 : a[i - 1][0]),
                                            a[i][3] + maxTugriks(a, dp, i, dough - a[i][2], left - a[i][1]));
    }


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int dough = in.nextInt();
        int stuffN = in.nextInt();

        int[][] a = new int[stuffN + 1][4];
        int[][][] dp = new int[stuffN + 1][dough + 1][101];

        a[0][2] = in.nextInt();
        a[0][3] = in.nextInt();

        for (int i = 1; i <= stuffN; i++)
            for (int j = 0; j < 4; j++)
                a[i][j] = in.nextInt();

        for (int[][] x : dp)
            for (int[] y : x)
                Arrays.fill(y, -1);

        out.println(maxTugriks(a, dp, stuffN, dough, a[stuffN][0]));
    }
}
