package gameOfXor;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while( t-- > 0 )
        {
        	int n = in.nextInt();
        	int a[] = new int[n];
        	for(int i = 0 ; i < n ; i++)
        	{
        		a[i] = in.nextInt();
        	}
        	if(n % 2 ==0)
        	{
        		System.out.println(0);
        	}
        	else
        	{
        		int ans = 0;
        		for(int i =0 ; i < a.length ; i+=2)
        		{
        			ans= ans ^ a[i];
        		}
        		System.out.println(ans);
        	}
        }
	}

}
