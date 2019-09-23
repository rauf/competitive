package main.java.in.rauf.code;

import main.java.in.rauf.FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Triplets {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int p = in.nextInt();
        final int q = in.nextInt();
        final int r = in.nextInt();

        long[] a = in.nextLongArray(p);
        long[] b = in.nextLongArray(q);
        long[] c = in.nextLongArray(r);

        long[] aSum = new long[p];
        long[] cSum = new long[r];

        Arrays.sort(a);
        Arrays.sort(c);

        aSum[0] = a[0];     // !!! sort before doing this
        cSum[0] = c[0];

        for (int i = 1; i < p; i++) {
            aSum[i] = a[i] + aSum[i - 1];
        }

        for (int i = 1; i < r; i++) {
            cSum[i] = c[i] + cSum[i - 1];
        }

        long res = 0;
        final long mod = 1000000007;

        for (int i = 0; i < q; i++) {
            long y = b[i];

            final long nX = smallerNums(a, y);
            if (nX == 0) continue;

            final long nZ = smallerNums(c, y);
            if (nZ == 0) continue;

            final long sX = aSum[(int) (nX - 1)];
            final long sZ = cSum[(int) (nZ - 1)];

            final long fir = ((sX % mod)* ((nZ * y + sZ) % mod)) % mod;
            final long sec = (((nX * nZ) % mod) * ((y * y) % mod)) % mod;
            final long third = (sZ % mod * ((nX * y) % mod)) % mod;

            res = (res % mod + (fir + sec + third) % mod) % mod;
        }
        out.println(res);
    }

    private int smallerNums(long[] arr, long elem) {

        //if (elem >= arr[arr.length - 1]) return arr.length;

        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (elem >= arr[mid]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
