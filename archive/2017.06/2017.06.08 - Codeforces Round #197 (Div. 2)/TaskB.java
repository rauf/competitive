package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();
        final int m = in.nextInt();

        int[] a = in.nextIntArray(m);

        int curr = 1;
        long res = 0;

        for (int x : a) {
            if (x > curr) {
                res += x - curr;
                curr = x;
            } else if (x < curr) {
                res += n - (curr - x);
                curr = x;
            }
        }
        out.println(res);
    }
}
