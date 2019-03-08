package nonRepeatChar;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int[] a = new int[256];
		for(int i = 0 ; i < s.length() ; i++ )
		{
			a[s.charAt(i)]++;
		}
		int flag = 0; 
		for(int i = 0 ; i < s.length() ; i++ )
		{
			if(a[s.charAt(i)] == 1)
			{
				flag = 1; 
				System.out.println(s.charAt(i));
				break;
			}
		}
		if(flag == 0 )
		{
			System.out.println("None");
		}
	}

}
