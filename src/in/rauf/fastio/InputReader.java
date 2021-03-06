package in.rauf.fastio;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class InputReader {

  private InputStream     stream;
  private byte[]          buf = new byte[1024];
  private int             curChar;
  private int             numChars;
  private SpaceCharFilter filter;

  public InputReader(InputStream stream) {
    this.stream = stream;
  }

  private int read() {
      if (numChars == -1) {
          throw new InputMismatchException();
      }
    if (curChar >= numChars) {
      curChar = 0;
      try {
        numChars = stream.read(buf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
        if (numChars <= 0) {
            return -1;
        }
    }
    return buf[curChar++];
  }

  public int integer() {
    int c = read();
      while (isSpaceChar(c)) {
          c = read();
      }
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    int res = 0;
    do {
        if (c < '0' || c > '9') {
            throw new InputMismatchException();
        }
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public String string() {
    int c = read();
      while (isSpaceChar(c)) {
          c = read();
      }
    StringBuilder res = new StringBuilder();
    do {
      res.appendCodePoint(c);
      c = read();
    } while (!isSpaceChar(c));
    return res.toString();
  }

  public char character() {
    return next().charAt(0);
  }

  public BigDecimal bigDecimal() {
    return new BigDecimal(next());
  }

  public BigInteger bigInteger() {
    return new BigInteger(next());
  }

  public double doublee() {
    int c = read();
      while (isSpaceChar(c)) {
          c = read();
      }
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    double res = 0;
    while (!isSpaceChar(c) && c != '.') {
        if (c == 'e' || c == 'E') {
            return res * Math.pow(10, integer());
        }
        if (c < '0' || c > '9') {
            throw new InputMismatchException();
        }
      res *= 10;
      res += c - '0';
      c = read();
    }
    if (c == '.') {
      c = read();
      double m = 1;
      while (!isSpaceChar(c)) {
          if (c == 'e' || c == 'E') {
              return res * Math.pow(10, integer());
          }
          if (c < '0' || c > '9') {
              throw new InputMismatchException();
          }
        m /= 10;
        res += (c - '0') * m;
        c = read();
      }
    }
    return res * sgn;
  }

  public long longg() {
    int c = read();
      while (isSpaceChar(c)) {
          c = read();
      }
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    long res = 0;
    do {
        if (c < '0' || c > '9') {
            throw new InputMismatchException();
        }
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public boolean isSpaceChar(int c) {
      if (filter != null) {
          return filter.isSpaceChar(c);
      }
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  private String next() {
    return string();
  }

  public int[] intArray(int size) {
    int[] array = new int[size];
      for (int i = 0; i < size; i++) {
          array[i] = integer();
      }
    return array;
  }

  public long[] longArray(int size) {
    long[] array = new long[size];
      for (int i = 0; i < size; i++) {
          array[i] = longg();
      }
    return array;
  }

  public long[][] long2dArray(int row, int col) {
    long[][] array = new long[row][col];
      for (int i = 0; i < row; ++i) {
          for (int j = 0; j < col; ++j) {
              array[i][j] = longg();
          }
      }
    return array;
  }

  public long[][] long2dArray(int size) {
    return long2dArray(size, size);
  }


  public int[][] int2dArray(int row, int col) {
    int[][] array = new int[row][col];
      for (int i = 0; i < row; ++i) {
          for (int j = 0; j < col; ++j) {
              array[i][j] = integer();
          }
      }
    return array;
  }

  public int[][] int2dArray(int size) {
    return int2dArray(size, size);
  }

  public char[][] char2dArray(int size) {
    char[][] array = new char[size][size];
      for (int i = 0; i < size; ++i) {
          array[i] = next().toCharArray();
      }
    return array;
  }

  public interface SpaceCharFilter {

    boolean isSpaceChar(int ch);
  }
}