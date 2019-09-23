package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();
        final int k = in.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int x = in.nextInt() + k;
            if (x <= 5) count++;
        }
        out.println(count / 3);
    }
}
