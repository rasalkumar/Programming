package helpAshu;
import java.util.*;
public class BitSolution {
	static int max = 100005;
	static int BIT[];
	static int a[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		a = new int[max];
		BIT = new int[max];
		for(int i = 1; i <= n ; i++ )
		{
			a[i] = in.nextInt();
			if(a[i] % 2 == 0)
			{
				upd(i,1);
			}
		}
		System.out.println("***");
		int q = in.nextInt();
		while(q -- > 0)
		{
			int ch = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			if(ch == 0)
			{
				if(r % 2 == 1 && a[l] % 2 == 0)
					upd(l, -1);
				if(r % 2 == 0 && a[l] % 2 == 1)
					upd(l,1);
				a[l] = r;
			}
			else if(ch == 1)
			{
				int cnt = query(r) - query(l-1);
				System.out.println(cnt);
			}
			else
			{
				int cnt = query(r) - query(l-1);
				System.out.println(r -l + 1 - cnt);
			}
		}
	}
	static void upd(int idx , int val)
	{
		for(int i = idx ;i < max ; i+=i&(-i))
		{
			BIT[i] += val;
		}
	}
	static int query(int val)
	{
		int ret = 0;
		while(val > 0)
		{
			ret +=BIT[val];
			val -= val & (-val);
		}
		return ret;
	}
}
