package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int[][] a= new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < 4; i++) {
            if (a[i][3] == 0) continue;

            int op = (i + 2) % 4;
            int l = 3;
            if (op != 0) l = (op - 1) % 4;

            int r = (op + 1) % 4;

            if (a[op][1] == 1 || a[l][0] == 1 || a[r][2] == 1 || a[i][1] == 1 || a[i][0] == 1 || a[i][2] == 1) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");

    }
}
