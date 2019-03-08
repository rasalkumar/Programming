package waysToDecode;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.next();
		Solution obj = new Solution();
		System.out.println(obj.numDecodings(a));
		
	}
	public int numDecodings(String a) {
        if(a.equals("0"))
        {
            return 0;
        }
        int n = a.length();
        for(int i = 1 ; i < n ;i++ )
        {
            if(a.charAt(i)=='0')
            {
            	if(a.charAt(i-1)=='3'||a.charAt(i-1)=='4'||a.charAt(i-1)=='5'||a.charAt(i-1)=='6'||
            			a.charAt(i-1)=='7'||a.charAt(i-1)=='8'||a.charAt(i-1)=='9' ||a.charAt(i-1)=='0')
            	{
            		return 0;
            	}
            }
        }
        int[] dp = new int[n];
        for(int i = 0 ; i < n  ; i++ )
        {
            dp[i] = 1;
        }
        for(int i = 1 ; i  < n ; i++ )
        {
            if(a.charAt(i-1) == '1' && a.charAt(i) != '0')
            {
                dp[i] = 2 * dp[i-1]; 
            }
            else if(a.charAt(i-1)=='2' && (a.charAt(i)=='1'||a.charAt(i)=='2'||
                    a.charAt(i)=='3'||a.charAt(i)=='4'||
                    a.charAt(i)=='5'||a.charAt(i)=='6'))
            {
                dp[i] = 2 * dp[i-1];
            }
            else
            {
                dp[i] = dp[i-1];
            }
        }
        return (dp[n-1]);

    }

}
