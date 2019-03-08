package oracle;
import java.util.*;
public class NthSequenceNaturalNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n <= 9)
		{
			System.out.println(n);
		}
		else if(n <= 189)
		{
			n = n - 9;
			int m = n % 2;
			n = (n / 2) + m     ;
			n = 9 + n;
			String s = String.valueOf(n);
			if (m == 0)
				m = 2;
			System.out.println(s.charAt(m-1));
		}
		else 
		{
			n = n - 189;
			int m = n % 3;
			n = n / 3 + m;
			n = n + 99;
			String s = String.valueOf(n);
			if(m==0)
				m=3;
			System.out.println(s.charAt(m -1));
			
		}

	}

}
