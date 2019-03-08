package gcd;
import java.util.*;
public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(gcd(a,b));
	}
	public static int gcd(int a ,int b)
	{
		if(b == 0)
			return a;
		return gcd(b,a%b);
	}

}
