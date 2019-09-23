package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();
        final int sum = in.nextInt();

        long[] a = in.nextLongArray(n);
        long[] b = new long[n];

        long low = 1;
        long high = n;
        long k = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long get = getRes(a, b, mid);

            if (get <= sum) {
                low = mid + 1;
                k = mid;
            }
            else high = mid - 1;
        }

        if (k == -1) {
            out.println("0 0");
            return;
        }
        out.println(k + " " + getRes(a, b, k));
    }

    private long getRes(long[] a, long[] b, long k) {

        for (int i = 0; i < b.length; i++) {
            b[i] = a[i] + k * (i + 1);
        }

        Arrays.sort(b);
        long get = 0;

        for (int i = 0; i < k; i++) {
            get += b[i];
        }
        return get;
    }
}
