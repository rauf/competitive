package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();

        int[] a = in.nextIntArray(n);
        int[] b = new int[100];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            b[a[i] - 1]++;
            sum += a[i];
        }

        int s = 0;
        int count = 0;

        for (int i = 99; i >= 0; --i) {
            if (b[i] == 0) continue;

            while (b[i] != 0) {
                s += (i + 1);
                b[i]--;
                count++;
                if (s >= sum / 2 + 1) {
                    out.println(count);
                    return;
                }
            }
        }
        out.println(count);
    }
}
