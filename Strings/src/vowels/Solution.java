package vowels;

/*You are given an Integer N.

You have to find how many different strings of length N can be made using Vowels (a, e, i, o, u) 
only and by following given rules :

‘a’ can only be followed by ‘e’ and ‘i’.

‘e’ can only be followed by ‘i’.

‘i’ can only be followed by ‘a’, ‘e’, ‘o’, and ‘u’.

‘o’ can only be followed by ‘a’ and ‘u’.

‘u’ can only be followed by ‘o’ and ‘e’.

for example N = 2

strings starting with 'a' of length 2 are:
    1. "ae"
    2. "ai"
strings starting with 'e' of length 2 are:
    1. "ei"
strings starting with 'i' of length 2 are:
    1. "ia"
    2. "io"
    3. "iu"
    4. "ie"
strings starting with 'o' of length 2 are:
    1. "oa"
    2. "ou"
strings starting with 'u' of length 2 are:
    1. "uo"
    2. "ue"

so total number of strings can be made using vowels and following above rules will be 11.
 

Input Format

Given the only argument N of type Integer.
Output Format

Return a single Integer X mod (1e9 + 7), i.e number of Strings that can be made using vowels 
and following above rules.
Constraints

1 <= N <= 1e5
strings will have only lowercase letters.
Example

Input:
   N = 1
    
Output:
	5

Explanation:
	Strings of length 1 are :
	1. "a"
	2. "e"
	3. "i"
	4. "o"
	5. "u"

Input:
   N = 2
    
Output:
	11

Explanation:
	as explained above.
 * 
 */



import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long mod = 1000000007;
		long dp[][] = new long[2][5];
		//Arrays.fill(dp[0], 0);
		//Arrays.fill(dp[1], 0);
		for(int  i = 0 ; i < 5 ; i++)
		{
			dp[1][i] = 1;
		}
		int x = 2 ^ 3;
		//System.out.println(1 ^1);
		System.out.println(x);
		for(int i = 2 ; i <= n ; i++ )
		{
			 int j = 1 & i ;
			 
			 dp[j][0] = (dp[j ^ 1][1] + dp[j ^ 1][2]) % mod;     // curr_a = (pre_e + pre_i)
		     dp[j][1] = (dp[j ^ 1][2]) % mod;                    // curr_e = (pre_i)
		     dp[j][2] = (dp[j ^ 1][0] + dp[j ^ 1][1] + dp[j ^ 1][3] + dp[j ^ 1][4]) % mod;     // curr_i = (pre_a + pre_e + pre_o + pre_u)
		     dp[j][3] = (dp[j ^ 1][0] + dp[j ^ 1][4]) % mod;     // curr_o = (pre_a + pre_u)
		     dp[j][4] = (dp[j ^ 1][1] + dp[j ^ 1][3]) % mod;     // curr_u = (pre_e + pre_o)
		}
		long ans = 0 ;
		for(int i = 0 ; i < 5 ; i++)
		{
			System.out.println(dp[n&1][i]);
			ans  = (( ans % mod ) + ( dp[n&1][i] % mod )) % mod;
		}
		System.out.println((int)(ans % mod));
	}	
}
