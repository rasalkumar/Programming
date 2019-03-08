package pin;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Rasal
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		StrikeOrSpare solver = new StrikeOrSpare();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class StrikeOrSpare {
		public void solve(int testNumber, Scanner in, PrintWriter out) {
			int n = in.nextInt();
			if (n == 1) {
				out.println("1" + " " + "1");
			} else {
				int p = 1;
				StringBuilder sb = new StringBuilder("1");
				for (int i = 1; i <= (n / 2); i++) {
					sb.append("0");
				}

				out.println(p + " " + String.valueOf(sb));
			}

		}
	}
}
