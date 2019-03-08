package dec9;
import java.util.*;
public class ShootingBalloons {
	static int b[];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		b = new int[n + 2];
		b[0] = 1; 
		b[n+1] = 1 ;
		for(int i = 1 ; i < n + 1 ; i++)
			b[i] = in.nextInt();
		System.out.println(helper(0, n + 1));
		
	}
	public static int helper(int left ,int right)
	{
		int max = 0;
		for(int i = left + 1 ; i < right ; i++)
		{
			int curr = helper(left,i) + helper(i,right); 
			if( left == 0 && right == n + 1 )
				curr += b[i]; 
			else
				curr += b[left] * b[right];
			if(curr > max)
				max = curr;
		}
		return max;
	}

}
