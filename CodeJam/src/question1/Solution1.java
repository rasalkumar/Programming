package question1;
import java.util.*;
public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0)
		{
			int n = in.nextInt();
			int o = in.nextInt();
			long d = in.nextLong();
			long x1 = in.nextLong();
			long x2 = in.nextLong();
			long a = in.nextLong();
			long b = in.nextLong();
			long c = in.nextLong();
			long m = in.nextLong();
			long l = in.nextLong();
			long x[] = new long[n];
			long s[] = new long[n];
			x[0] = x1;
			x[1] = x2;
			s[0] = x[0] + l;
			s[0] = x[1] + l;
			for(int i = 2  ; i < n ; i++ )
			{
				x[i] =( (a * x[i-1]) + (b * x[i-2]) + c ) % m;
				s[i] = x[i] + l;
			}
			int i = 0 ; 
			int  j = 0 ; 
			long addSweet= 0;
			long cOdd = 0;
			Arrays.sort(s);
		//	ArrayList<Long> afa =new ArrayList 
			//HashSet<Array>
			while(i<s.length && addSweet < d && cOdd < o)
			{
				if((addSweet +s[i] < d ) )
					addSweet = addSweet + s[i];
				if(s[i] % 2 = )
				
			}
		}
	}

}
