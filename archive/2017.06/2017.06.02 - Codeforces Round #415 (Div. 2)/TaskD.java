package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();

        int fir = find(1, n, n, in, out);

        int sec = find(1, fir - 1, n, in, out);

        if (!check(sec, fir, n, in, out))
            sec = find(fir + 1, n, n, in, out);

        out.println("2 " + fir + " " + sec);
        out.flush();
    }

    private int find(int low, int high, int n, InputReader in, PrintWriter out) {
        if (low > high) return -1;

        while (low < high) {
            final int mid1 = low + (high - low) / 2;
            if (check(mid1, mid1 + 1, n, in, out)) {
                high = mid1;
            } else low = mid1 + 1;
        }
        return low;
    }

    private boolean check(int x, int y, int n, InputReader in, PrintWriter out) {
        if (x < 0 || y > n) return false;
        out.println("1 " + x + " " + y);
        out.flush();
        return in.next().equals("TAK");
    }

}
