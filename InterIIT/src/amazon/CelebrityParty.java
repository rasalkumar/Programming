package amazon;
import java.util.*;
public class CelebrityParty {
static int matrix[][];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		matrix = new int[n][n];
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j <  n ; j++ )
			{
				matrix[i][j] = in.nextInt();
			}
		}
		System.out.println(findCelebrity(n));

	}
	static int findCelebrity(int n)
	{
		Stack<Integer> st = new Stack<>();
		int c;
		for( int i = 0 ; i < n ; i++ )
		{
			st.push(i);
		}
		
		while(st.size() > 1)
		{
			int a = st.pop();
			int b = st.pop();
			//System.out.println(a +  " " + b);
			if(knows(a,b))
			{
				st.push(b);
			}
			else
				st.push(a);
		}
		c = st.pop();
		//System.out.println();
		for(int  i = 0 ; i < n ;i++)
		{
			if(i != c && (knows(c,i) || !knows(i,c)))
				return -1;
		}
		return c;
	}
	static boolean knows(int a ,int b)
	{
		return matrix[a][b] == 1 ? true  :false; 
	}

}
