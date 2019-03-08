package test3;
import java.util.*;
class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			int n = in.nextInt();
			//in.nextLine();
			String s = in.next();
			//System.out.println(n + "  " + s);
			
			long count = 0;
			int length = 1;
			for(int i = 1 ; i < s.length() ;i++)
			{
				if(s.charAt(i) >= s.charAt(i - 1))
				{
					length++;
				}
				else
				{
					count += (length)*(length + 1) / 2;
					length = 1;
				}
			}
			count += (length)*(length + 1) / 2;
			System.out.println(count);
		}
	}

}
