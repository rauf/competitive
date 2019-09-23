package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();
        final int k = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(n - i).append(' ');
        }

        for (int i = 1; i <= (n - k); i++) {
            sb.append(i).append(' ');
        }
        out.println(sb);
    }
}
