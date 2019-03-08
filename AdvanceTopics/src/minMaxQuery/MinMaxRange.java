package minMaxQuery;
import java.util.*;
public class MinMaxRange {
	static int a[];
	static int tree[];
	static int lazy[];
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			a = new int[1000005];
			tree = new int[3000005];
			lazy = new int[3000005];
			int n = in.nextInt();
			for(int i = 1 ; i <= n ; i++ )
			{
				int g = in.nextInt();
				a[i] = g;
			}
			build(1,1,n);
			for(int k = 1 ; k < 2 * n ;k++ )
			{
				System.out.println(tree[k] + "*");
			}
			System.out.println(query(1,1,n,1,3));
			update(1,1,n,2,3, 4);
			for(int k = 1 ; k < 2 * n ;k++ )
			{
				System.out.println(tree[k] + "**");
			}
			System.out.println(query(1,1,n,1,3));
		}
	}
	// Build the tree
	static void build(int i, int start,int end)
	{
		if(start > end)
			return;
		if(start == end)
		{
			tree[i] = a[start];
			return ;
		}
		int mid = start + ((end - start) / 2 );
		build(2 *i , start, mid);
		build((2 * i) + 1, mid+1 ,end);
		tree[i] = Math.max(tree[2 * i], tree[(2 * i) + 1]);
	}
	// Increments Elements within range[l...r] with value value
	static void update(int i ,int start,int end ,int l, int r, int value)
	{
		if( lazy[i] != 0 )
		{
			tree[i] += lazy[i];
			if( l != r )
			{
				lazy[2 * i] += lazy[i];        //Mark Child as Lazy
				lazy[(2 * i) + 1] += lazy[i];  //Mark Child as Lazy
			}
			lazy[i] = 0 ; //Reset it
		}
		if(start > end || r < start || l > end)
			return ;
		if(start >= l && end <= r)
		{
			tree[i] += value;
			if(start != end)
			{
				lazy[2 * i] += value;
				lazy[(2 * i) + 1] += value;
			}
			return;
		}
		int mid = start + ((end - start) / 2) ; 
		update(2 * i, start ,  mid , l , r , value);
		update(2 * i + 1, mid + 1 ,  end , l , r , value) ;
		tree[i] = Math.max(tree[2 * i], tree[(2 * i) + 1 ]);
	}
	static int query(int i , int start ,int end,int l, int r)
	{
		if(start > end || r < start || l > end)
			return Integer.MIN_VALUE;
		if( lazy[i] != 0 )
		{
			tree[i] += lazy[i];
			if( l != r )
			{
				lazy[2 * i] += lazy[i];        //Mark Child as Lazy
				lazy[(2 * i) + 1] += lazy[i];  //Mark Child as Lazy
			}
			lazy[i] = 0 ; //Reset it
		}
		if(start >= l && end <= r)
		{
			return tree[i];
		}
		int mid = start + ((end - start) / 2 );
		int p1 = query(2 * i, start, mid, l, r);
		int p2 = query((2 * i) + 1, mid + 1, end, l, r);
		int res = Math.max(p1,p2);
		return res;
	}
	
}
