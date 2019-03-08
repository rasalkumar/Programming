package littleChefAndSums;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rasal
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        LittleChefAndSums solver = new LittleChefAndSums();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class LittleChefAndSums {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            long prefix[] = new long[N];
            long suffix[] = new long[N];
            prefix[0] = a[0];
            for (int i = 1; i < N; i++) {
                prefix[i] = prefix[i - 1] + a[i];
            }
            suffix[0]=prefix[N-1];
            for (int i = 1; i < N; i++) {
                suffix[i] = suffix[i - 1] - a[i-1];
            }
            long min = Long.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < N; i++) {
                if (min > (prefix[i] + suffix[i])) {
                    min = prefix[i] + suffix[i];
                    index = i;
                   // out.println(index+"  " +min);
                }
            }
            out.println(index + 1);
        }

    }
}


