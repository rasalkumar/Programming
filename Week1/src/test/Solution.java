package test;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long a = 1 ;
		long b = 1 ;
		for(int i = 3; i <= n ;i++ )
		{
			if(i % 2 == 1)
				a = a * 2;
			else
				b = b * 3;
		}
		if(n % 2 == 1)
			System.out.println(a);
		else
			System.out.println(b);
	}

}
