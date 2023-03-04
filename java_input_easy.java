import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.OptionalInt;
import java.io.InputStream;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        BallElimination solver = new BallElimination();
        solver.solve(1, in, out);
        out.close();
    }
    static class BallElimination {
        public int[] arr;
        public int[][] dp;
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            arr = in.readIntArray(n);
            dp = new int[n][n];
            for (int[] x : dp) Arrays.fill(x, -1);
            out.println(solve(0, n - 1));
        }
        public int solve(int start, int end) {
            if (start > end) return 0;
            if (dp[start][end] != -1) {
                return dp[start][end];
            }
            return dp[start][end] = Math.min(
                    solve(start, end - 1) + 1,
                    IntStream.range(start, end).parallel()
                            .filter(mid -> arr[end] == arr[mid])
                            .map(mid -> solve(start, mid - 1) + solve(mid + 1, end - 1))
                            .min()
                            .orElse(end - start + 1)
            );
        }
    }
    static class OutputWriter {
        private final PrintWriter writer;
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
        public void close() {
            writer.close();
        }
        public void println(int i) {
            writer.println(i);
        }
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        public int[] readIntArray(int tokens) {
            int[] ret = new int[tokens];
            for (int i = 0; i < tokens; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }
        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;
                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }
                    if (this.numChars <= 0) {
                        return -1;
                    }
                }
                return this.buf[this.curChar++];
            }
        }
        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }
            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }
            int res = 0;
            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }
            throw new InputMismatchException();
        }
        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }
    }
}
