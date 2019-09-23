package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final long n = in.nextLong();

        long x = n;

        int count = 0;

        while (x > 0) {
            long y = x % 10;
            if (y == 4 || y == 7) count++;
            x /= 10;
        }

        if (count == 0) {
            out.println("NO");
            return;
        }

        while (count > 0) {
            int y = count % 10;
            if (y != 4 && y != 7) {
                out.println("NO");
                return;
            }
            count /= 10;
        }
        out.println("YES");
    }
}
