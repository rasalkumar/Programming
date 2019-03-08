package totalNumberOfStrings;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while( t-- > 0)
        {
        	int n = in.nextInt();
        	long ans = 0;
        	ans = (( n * n * n ) + (( 3 * n ) + 2 )) / 2;
        	System.out.println(ans);
        }
	}

}
