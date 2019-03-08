package rainbow;

import java.io.OutputStream;
//import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
//import java.util.ArrayList;

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
        ChefAndRainbowArray solver = new ChefAndRainbowArray();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ChefAndRainbowArray {
        public void solve(int testNumber, Scanner in, PrintWriter out) {


            int N = in.nextInt();
            boolean flag = true;
            int a[] = new int[N];
            for (int j = 0; j < N; j++) {
                a[j] = in.nextInt();

            }


            if (a[0] != 1 || a[a.length - 1] != 1) {
                flag = false;
            }
            if (flag == true) {
                int p = 1;
                int q = a.length - 2;
                while (p <= q) {
                    if (a[p] != a[q]) {
                        flag = false;
                        break;
                    }
                    if (a[p] < a[p - 1] || a[q] < a[q + 1]) {
                        flag = false;
                        break;
                    }
                    p++;
                    q--;

                }
            }
            if (flag == true) {
                int count = 0;
                int diff[] = new int[N];
                diff[0] = a[0];
                for (int j = 1; j < N; j++) {
                    diff[j] = a[j] - a[j - 1];
//                    out.println(diff[j]);
                }
                for (int j = 0; j < N; j++) {
                    if (Math.abs(diff[j]) > 1) {
                        flag = false;
                        break;
                    }
                    if (diff[j] == 1) {
                        count += 1;
                        //   max=Math.max(max,count);
                    }
                }
                if (count > 10 || count < 7) {
                    flag = false;
                }
            }
            if(flag == true){
            	out.println("yes");
            }
            else
            	out.println("no");


        }

    }
}


