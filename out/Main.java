import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author abdul
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        private long MOD = (long) (1e9 + 7);

        public void solve(int testNumber, InputReader in, PrintWriter out) {

            final int n = in.nextInt();
            int[] a = in.nextIntArray(n);
            long res = 0;

            Random r = new Random();
            for (int i = 0; i < 100000; i++) {
                int x = r.nextInt(n), y = r.nextInt(n);
                int temp = a[x];
                a[x] = a[y];
                a[y] = temp;
            }

            Arrays.sort(a);

            long[] pow2 = new long[n];
            pow2[0] = 1;

            for (int i = 1; i < n; i++) {
                pow2[i] = (pow2[i - 1] << 1) % MOD;
            }

            for (int i = 0; i < n; i++) {
                long left = pow2[i];
                long right = pow2[n - i - 1];
                res = (res + ((left - right) * a[i]) % MOD) % MOD;
            }
            out.println(res);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
                array[i] = nextInt();
            return array;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);

        }

    }
}

