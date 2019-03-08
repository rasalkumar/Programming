package remainingString;
import java.util.*;
import java.io.*;
public class GFG {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			String s=in.next();
			char c=in.next().charAt(0);
			int count=in.nextInt();
			int count1 = 0;
			int flag = 0 ;
			for(int i = 0 ; i < s.length() ; i++ )
			{
				if(s.charAt(i) == c)
				{
					count1++;
				}
				if(count1 == count)
				{
					flag = 1;
					System.out.println(s.substring(i));
					break;
				}
			}
			if(flag == 0)
			{
				System.out.println("");
			}
		}
	}

}
