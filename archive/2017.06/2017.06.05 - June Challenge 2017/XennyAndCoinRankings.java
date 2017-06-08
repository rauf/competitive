package com.company.code;

import com.company.FastIO.InputReader;

import java.io.PrintWriter;

public class XennyAndCoinRankings {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        final long x = in.nextLong();
        final long y = in.nextLong();
        long n = x + y;
        n = (n + 1) * n / 2;
        out.println(n + x + 1);
    }
}
