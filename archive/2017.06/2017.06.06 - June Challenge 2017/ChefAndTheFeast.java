package com.company.code;

import com.company.FastIO.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class ChefAndTheFeast {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int n = in.nextInt();

        int[] a = in.nextIntArray(n);

        Arrays.sort(a);

        long sum = 0;
        long posSum = 0;
        long negSum = 0;
        long neg = 0;
        long res = 0;
        boolean b = true;

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] >= 0) {
                posSum += a[i];
                sum = posSum;
                res = Math.max(res, posSum * (n - i));
            } else {
                negSum += a[i];
                if (-negSum <= posSum && b) {
                    sum += a[i];
                    long x = sum * (n - i);
                    if (x > res) {
                        res = x;
                    } else {
                        neg = a[i];
                        b = false;
                    }
                } else {
                    neg += a[i];
                }
            }
        }
        out.println(res + neg);
    }
}
