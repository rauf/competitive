package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a = in.next();
        String b = in.next();

        for (int i = 0; i < a.length(); i++) {
            char ch1 = Character.toLowerCase(a.charAt(i));
            char ch2 = Character.toLowerCase(b.charAt(i));

            if (ch1 < ch2) {
                out.println(-1);
                return;
            } else if (ch1 > ch2) {
                out.println(1);
                return;
            }

        }
        out.println(0);
    }
}
