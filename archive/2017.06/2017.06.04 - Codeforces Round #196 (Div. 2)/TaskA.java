package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();
        final int m = in.nextInt();

        int[] a = in.nextIntArray(m);

        Arrays.sort(a);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= a.length - n; i++) {
            min = Math.min(min, a[i + n - 1] - a[i]);
        }
        out.println(min);
    }
}
