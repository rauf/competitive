package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskC {

    private long MOD = (long) (1e9 + 7);

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        final int n = in.nextInt();

        int[] arr = in.nextIntArray(n);
        long res = 0;

        for (int i = 0; i < n - 1; i++) {
            int max = arr[i];
            int min = arr[i];
            long count = 1;
            for (int j = i + 1; j < n; j++) {
                max = Math.max(arr[j], max);
                min = Math.min(arr[j], min);
                res += count * (max - min);
                res %= MOD;
                count *= 2;
            }
        }

        out.println(res);
    }
}
