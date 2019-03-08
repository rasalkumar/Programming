package test3;
import java.util.*;
public class NiceArches {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int count = 0;
		while(m-- > 0)
		{
			String s = in.next();
			int n = s.length();
			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			for(int i = 0 ; i < n ; i++)
			{
				if(s.charAt(i) == 'A')
				{
					a.add(i);
				}
				else
				{
					b.add(i);
				}
			}
//			System.out.println(a);
//			System.out.println(b);
			Interval[] ax = new Interval[a.size() -1];
			for(int i = 1 ;i < a.size() ;i++)
			{
				ax[i-1] = new Interval(a.get(i-1), a.get(i));
				//System.out.println(ax[i-1].start + " " + ax[i-1].end);
			}
			
			Interval[] bx = new Interval[a.size() -1];
			for(int i = 1 ;i < b.size() ;i++)
			{
				bx[i-1] = new Interval(b.get(i-1), b.get(i));
				//System.out.println(bx[i-1].start + " " + bx[i-1].end);
			}
			int i = 0 ; int j = 0;
			int flag = 0;
//			Interval curr;
//			if(s.charAt(0) == 'A')
//				curr = ax[i];
//			else
//				curr = bx[i];
			while( i < ax.length && j < bx.length )
			{
				if( ax[i].end <= bx[j].start )
				{
					//System.out.println("*");
					i++;
				}
				else if( ax[i].start >= bx[j].end)
				{
					//System.out.println("**");
					j++;
				}
				//else if( ax[i].end > bx[i].end)
				else if(ax[i].start <= bx[j].start && ax[i].end >= bx[j].end)
				{
					j++;
				}
				else if(bx[j].start <= ax[i].start && bx[j].end >= ax[i].end)
				{
					i++;
				}
				else if((ax[i].end > bx[j].start && ax[i].start < bx[j].end ) || (bx[j].start < ax[i].end && bx[j].end > ax[i].start) )
				{
					//System.out.println("***");
					flag =1;
					break;
				}
				 
							
			}
			if(flag != 1)
			{
				//System.out.println(s);
				count++;
			}
		}
		System.out.println(count);

	}
	static class Interval
	{
		int start,end;
		Interval(int start,int end)
		{
			this.start =start;
			this.end = end;
		}
	}

}
