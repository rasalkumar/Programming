package amazon;
import java.util.*;
public class MaxPossibleByKSwaps {
static String max;
static String ans;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int k = in.nextInt();
		//max = s.toCharArray();
		max = s;
		System.out.println(new String(max));
		maxSteps(s.toCharArray(), k );
		System.out.println(max.toString());

	}
	static void maxSteps(char[] str, int k )
	{
		if( k == 0 )
			 return ;
		for(int i = 0 ; i < str.length ; i++ )
		{
			for(int j = i + 1 ; j < str.length ; j++)
			{
				if(str[i] < str[j])
				{
					swap(str,i,j);
				}
				if(new String(str).compareTo(max) > 0)
				{
					max = new String(str);
					
				}
				maxSteps(str, k-1);
				swap(str,i, j);
			}
			
		}
	}
	static void swap(char[] s, int i , int j)
	{
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

}
