package summaryPower;

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
        SummaryPower solver = new SummaryPower();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SummaryPower {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next().toLowerCase();
            String[] arr = new String[n - k + 1];
            for (int i = 0; i < n - k + 1; i++) {
                arr[i] = s.substring(i, i + k);
            }
            int cost = 0;
            for (int i = 1; i < arr.length; i++) {
                int c = 0;
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) != arr[i - 1].charAt(j)) {
                        c = c + 1;
                    }
                }
                cost += c;
            }
            out.println(cost);
        }

    }
}

