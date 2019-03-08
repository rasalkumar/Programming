package q1;

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
        ModuloEquality solver = new ModuloEquality();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ModuloEquality {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            long c[] = new long[n];
            long x = Integer.MAX_VALUE;
            long minB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                if (b[i] < minB) {
                    minB = b[i];
                }
            }
            //  HashMap<Long,Long> map=new HashMap<>();

            for (int i = 0; i < n; i++) {
                c[i] = a[i] % b[i];
                //    if(map.containsKey(c[i]))
                //  {
                //    map.put(c[i],map.get(c[i])+1);
                //   }
                //else
                //     {
                //       map.put(c[i],(long)(1));
                // }
                if (Math.abs(c[i] - minB) < x) {
                    x = c[i];
                }
            }
            long count = 0;
            for (int i = 0; i < n; i++) {
                if (c[i] < x) {
                    count += x - c[i];
                } else if(c[i]>x)
                {
                    count += (b[i] + x) - a[i];
                }
            }
          //  out.println(x);
           out.println(count);

        }

    }
}

