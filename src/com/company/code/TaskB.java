package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {

    private void lights(int floor, int[][] a, int[][] dp) {
        if (floor == a.length - 1) {

        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int m2 = m + 2;

        int[][] a = new int[n][m2];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') a[i][j] = 1;
            }
        }


    }

}
