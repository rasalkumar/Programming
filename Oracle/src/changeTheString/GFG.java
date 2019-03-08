package changeTheString;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0 )
		{
			String s = in.next();
			if(s.charAt(0) >= 65 && s.charAt(0) <= 90)
			{
				System.out.println(s.toUpperCase());
			}
			else
			{
				System.out.println(s.toLowerCase());
			}
		}
		
	}

}
