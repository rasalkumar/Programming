package magicNumber;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
        while( t-- > 0 )
        {
        	int n = in.nextInt();
        	int p = 1, res = 0;
        	while (n>=1)
        	{
        	p = p*5;
        	if ((n&1) == 1)
        	res += p;
        	n >>= 1;
        	}
        	System.out.println(res);
        }
        
	}

}
