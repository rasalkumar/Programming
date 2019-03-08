package fancyQuotes;
import java.util.*;
public class FancyQuotes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.next();
		while( t-- > 0 )
		{
			String s = in.nextLine();
			StringTokenizer str = new StringTokenizer(s, " ");
			int flag = 0 ;
			while(str.hasMoreTokens())
			{
				String p = str.nextToken();
				//System.out.println(p);
				if(p.equals("not"))
				{
					flag = 1;
					//System.out.println(p);
					break;
				}
			}
			System.out.println(flag == 1 ? "Real Fancy" : "regularly fancy");
			
		}

	}

}
