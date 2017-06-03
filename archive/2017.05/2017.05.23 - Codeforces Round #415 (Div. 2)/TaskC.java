package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class TaskC {

    private long MOD = (long) (1e9 + 7);

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        final int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        long res = 0;

        Random r = new Random();
        for(int i = 0; i < 100000; i++) {
            int x = r.nextInt(n), y = r.nextInt(n);
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
        }

        Arrays.sort(a);

        long[] pow2 = new long[n];
        pow2[0] = 1;

        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] << 1) % MOD;
        }

        for (int i = 0; i < n; i++) {
            long left = pow2[i];
            long right = pow2[n - i - 1];
            res = (res + ((left - right) * a[i]) % MOD) % MOD;
        }
        out.println(res);
    }
}
