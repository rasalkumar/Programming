package hillJumping;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;
 
/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Rasal
 */
public class Main2 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		HillJumping solver = new HillJumping();
		int testCount = 1;
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
 
	static class HillJumping {
		
		public void solve(int testNumber, Scanner in, PrintWriter out) {
			int N = in.nextInt();
			int Q = in.nextInt();
			long a[] = new long[N];
			for (int i = 0; i < N; i++) {
				a[i] = in.nextLong();
			}
			for (int p = 0; p < Q; p++) {
				int type = in.nextInt();
				if (type == 1) {
					int i = in.nextInt();
					int k = in.nextInt();
					int y = i - 1;
                 
					int start = y + 1;
					int end;
					if(N<100)
					{
						end=N-1;
					}
					else if(y+100<N)
					{
					 end=y+100;
					}
					else
					{
						end=N-1;
					}
					while(start<=end)
					{
						if(a[start]<=a[y])
						{
							start++;
						}
						if(a[end]<=a[y])
						{
							end--;
						}
						if(a[start]>a[y])
						{
							
						}
					}
					
									out.println(y + 1);
 
				}
				if (type == 2) {
					int L = in.nextInt();
					int R = in.nextInt();
					int X = in.nextInt();
					for (int j = L - 1; j < R; j++) {
						a[j] = a[j] + X;
					}
				}
			}
 
		}
 
	}
}
