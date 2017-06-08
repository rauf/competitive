package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();

        int lim = 10000000;
        boolean[] a = new boolean[lim];   //false for prime, true for not prime.

        for (int i = 2; i < lim; i++) {
            if (a[i]) continue;
            for (int j = 2 * i; j < lim; j += i) {
                a[j] = true;
            }
        }

        int t = n;
        StringBuilder sb = new StringBuilder();

        for (int i = 2; t > 0 && i < lim; i++) {
            if (!a[i]) {
                sb.append(i).append(' ');
                t--;
            }
        }
        out.println(sb);

    }
}
