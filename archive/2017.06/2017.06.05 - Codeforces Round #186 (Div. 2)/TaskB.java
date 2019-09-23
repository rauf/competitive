package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();

        final int m = in.nextInt();

        int[] a = new int[s.length()];
        a[0] = 0;

        for (int i = 1; i < s.length(); i++) {

            a[i] = a[i - 1];

            if (s.charAt(i - 1) == s.charAt(i)) {
                a[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            sb.append(a[y - 1] - a[x - 1]).append('\n');
        }
        out.print(sb);
    }
}
