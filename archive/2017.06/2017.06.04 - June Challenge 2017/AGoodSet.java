package com.company.code;

import com.company.FastIO.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class AGoodSet {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();

        if (n == 1) {
            out.println("1");
            return;
        }

        if (n == 2) {
            out.println("1 2");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("1 2 4 ");

        n -= 3;
        int i = 7;


        while (n --> 0) {
            sb.append(i).append(' ');
            i += 3;
        }
        out.println(sb);
    }
}
