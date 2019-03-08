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
public class Main {
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
                 
					int j = y + 1;
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
				//	PriorityQueue<Long> pq= new PriorityQueue<>();
					while (k != 0 && j<=end && j-y<=100) {
						
						
						if (a[j] > a[y]) {
							k--;
							y = j;
							if(y+100<N)
							{
							 end=y+100;
							}
							else
							{
								end=N-1;
							}
 
						}
					//	int t=0;
						while(a[end]<a[y] && end>y)
						{
							end--;
					//		t=t+1;
						}
//						if(end==y)
//						{
//							break;
//						}
						
						j = j + 1;
 
					}
//                    int start=i-1;
//                    int temp=start;
//                    for(int m=start+1;m<N && k>0;i++)
//                    {
//                    	if(a[temp]<a[m])
//                    	{
//                    		if(m-temp<=100)
//                    		{
//                    			k--;
//                    			temp=m;
//                    		}
//                    		else
//                    		{
//                    			break;
//                    		}
//                    	}
//                    }
				//out.println(y + 1);
 
				}
				if (type == 2) {
					int L = in.nextInt();
					int R = in.nextInt();
					int X = in.nextInt();
					int lo=L-1;
					int hi=R-1;
					int val=X;
					add(a,N,lo,hi,val);
					updateArray(a, N);
				}
			}
 
		}
		static void add(long[] a, int N, int lo, int hi, int val)
		{
		    a[lo] += val;
		    if (hi != N - 1)
		       a[hi + 1] -= val;
		}
		 
		//  Utility method to get actual array from operation array
		static void updateArray(long[] a, int N)
		{
		    //  convert array into prefix sum array
		    for (int i = 1; i < N; i++)
		        a[i] += a[i - 1];
		}
 
	}
}