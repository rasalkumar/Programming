package dailyTest4;
import java.awt.geom.Dimension2D;
import java.util.*;
public class FindTheSequence {
	static int[] dp;
	//static String s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			long k = in.nextLong();
			dp = new int[n];
			//s = "";
			if(k > find("",n))
			{
				System.out.println(-1);
			}
			else
			{
				find("",n);
			}
		}
	}
	public static int find(String s,int n){
		if(s.length() == n){
			return 1;
		}
		if(s.length() == 0 || s.charAt(s.length()-1) == '0'){
			return find(s+"O", n) + find(s+"Z",n);	
		}
		return find(s+"Z", n);		
	}
	public static int find2(String s,int n){
		if(s.length() == n){
			System.out.println(s);
			return 1;
		}
		if(s.length() == 0 || s.charAt(s.length()-1) == 'Z'){
			return find(s+"O", n) + find(s+"Z",n);	
		}
		return find(s+"Z", n);	
		
	}
	 

}
