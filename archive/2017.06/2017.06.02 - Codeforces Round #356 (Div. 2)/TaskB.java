package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();
        final int a = in.nextInt() - 1;

        int[] arr = in.nextIntArray(n);

        int left = a - 1;
        int right = a + 1;
        int count = (arr[a] == 1) ? 1 : 0;

        while (left >= 0 || right < n) {

            int l = -1;
            int r = -1;

            if (left >= 0) l = arr[left--];
            if (right < n) r = arr[right++];

            if (l != -1 && r != -1) {
                if (l == 1 && r == 1) count += 2;
                continue;
            }

            if (l != -1) count += l;
            else if (r != -1) count += r;
        }
        out.println(count);
    }
}
