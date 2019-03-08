package quick;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
		ImmortalFrieza solver = new ImmortalFrieza();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class ImmortalFrieza {
		public void solve(int testNumber, Scanner in, PrintWriter out) {
			String s = in.next();
			HashSet<Character> set = new HashSet<>();
			String p = "frieza";
			for (int i = 0; i < p.length(); i++) {
				if (!set.contains(p.charAt(i))) {
					set.add(p.charAt(i));
				}
			}
			StringBuilder t = new StringBuilder("");
			int i = 0;
			int count = 0;
			while (i < s.length()) {
				if (i < s.length() && set.contains(s.charAt(i))) {
					while (i < s.length() && set.contains(s.charAt(i))) {
						count++;
						i++;
					}
					
					
				} else {
					while (i < s.length() && !set.contains(s.charAt(i))) {
						count++;
						i++;
					}
				}
				t.append(count);
                count = 0;
			}
			out.println(t);

		}

	}
}
