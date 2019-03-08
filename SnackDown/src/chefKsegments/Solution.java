package chefKsegments;
import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] l = new int[n];
			int[] r = new int[n];
			Interval[] intervals = new Interval[n];
			for (int i = 0; i < n; i++) {
				l[i] = in.nextInt();
				r[i] = in.nextInt();
				intervals[i] = new Interval(l[i], r[i]);
			}
			Arrays.sort(intervals);
			Interval pre = intervals[0];
			for(int i = 0 ; i < n ;i++   ){}
			
			
		}
	}
	static class Interval implements Comparable<Interval>
	{
		int l; int r;
		Interval(int l ,int r)
		{
			this.l = l;
			this.r = r;
		}
		public int compareTo(Interval other)
		{
			if(this.l != other.l)
			{
				return this.l - other.l;
			}
			return this.r - other.r;
		}
	}

}
