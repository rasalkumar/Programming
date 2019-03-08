package dailyTest3;
import java.util.*;
public class Solution {
	//static int MAX = 1000005; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int id = in.nextInt();
			//Stack<Integer> stack = new Stack<>();
			//Queue<Integer> q = new LinkedList<>();
			
			int k = id;
			int j = 0;
			for(int i = 0 ; i <  n ; i ++)
			{
				String x = in.next();
				if(x.equals("P"))
				{
					j = k;
					k = in.nextInt();
					
				}
				else
				{
					int temp = k;
					k = j;
					j = temp;
				}
			}
			System.out.println(k);
		}
	}

}
