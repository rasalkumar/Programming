package flipkart;

/*Given a long integer, , find the number of ways to represent it as a sum of two 
 * or more consecutive positive integers. For example:

If , then there are three such ways: .
If , then there are zero such ways.
Complete the  function in the editor below. It has one parameter: a long integer named .
 The function must return an integer denoting the number of ways to represent  as a sum 
 of two or more consecutive positive integers.

Input Format

The code needed to read a long integer denoting  from stdin and pass it to the function
 as been provided for you.

Constraints

Output Format

Return an integer denoting the number of ways to represent  as a sum of two or more consecutive positive integers.

Sample Input 0

15
Sample Output 0

3
Explanation 0

There are three ways to calculate  as a sum of two or more consecutive integers:

Thus, the function returns .

Sample Input 1

10
Sample Output 1

1
Explanation 1

There is one way to calculate  as a sum of two or more consecutive integers:

Thus, the function returns .
 * 
 */

import java.util.*;
public class ConsecutiveSum {

	static int consecutive(long num) {
        int ans = 0 ;
        for(long i = 2 ; i * i <= 2*num  ; i++ )
        {
            if( ((2 * num) - (i * (i - 1))) % (2 * i) == 0 )
            {
            	//System.out.println(i);
                ans += 1 ;
            }             
        }
        //System.out.println(Math.sqrt(417302));
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        int res = consecutive(num);
        System.out.println(res);
        in.close();
    }

}
