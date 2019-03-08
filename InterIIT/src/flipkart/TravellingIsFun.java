package flipkart;

/*
 * There are  cities numbered from  to . Two cities,  and ,
 *  are connected by a bidirectional road if and only if , 
 *  where  is the greatest common divisor of  and .
 *  Julia is planning a long vacation and wants to know whether a path exists from city  to city .

Complete the  function; it has four parameters:

Name	Type	Description
n	integer	The number of cities.
g	integer	Cities  and  are connected if and only if .
originCities	integer array	Each index  (where ) describes  for the  pair of cities.
destinationCities	integer array	Each index  (where ) describes  for the  pair of cities.
The function must return an array of  integers where the value at each index  (where ) is  if a path exists from city  to city ; otherwise, it's  instead.

Input Format

The code to read the inputs from stdin and to pass it to the function  is provided for you. The below is documentation in case you need to create custom testcases.

The first line contains an integer denoting .
The second line contains an integer denoting .
The third line contains an integer, , denoting the total number of elements in .
Each line  of  subsequent lines (where ) contains an integer describing .
The next line contains an integer, , denoting the total number of elements in .
Each line  of  subsequent lines (where ) contains an integer describing .
Constraints

 where 
 where 
Output Format

Return an array of  integers where the value at each index  (where ) is  if a path exists from city  to city ; otherwise, it's  instead.

Sample Input 0

6
0
4
1
4
3
6
4
3
6
2
5
Sample Output 0

1
1
1
1
Sample Input 1

6
1
4
1
2
4
6
4
3
3
3
4
Sample Output 1

0
1
1
1
 * 
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TravellingIsFun {
    static int a[];
    static int s[];
    static int max = 2000005;
    
    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        a = new int[max];
        s = new int[max];
        for(int i = 1 ; i <= n ; i++ )
        {
            a[i] = i;
            s[i] = 1;
        }
        int ans[] = new int[originCities.length];
        
        for (int k = g + 1; k <= n; k++) {
            for (int x = 2 * k; x <= n; x += k) {
                union(x , x - k );
            }
        }
        for(int i = 0 ; i < originCities.length ; i++ )
        {
        	if(isConnected(originCities[i],destinationCities[i]))
            {
        		ans[i] = 1;
            }
        	else
        	{
        		ans[i] = 0;
        	}
        }
        return ans;
    }
    public static int root(int v)
    {
        while( v != a[v] )
        {
            v = a[a[v]];
        }
        return v;
    }
    public static boolean isConnected(int a , int b)
    {
        return (root(a) == root(b));
    }
    public static void union(int x ,int y)
    {
        int root_a = root(x);
        int root_b = root(y);
        if(root_a == root_b)
            return;
        int s1 = s[root_a];
        int s2 = s[root_b];
        if(s1 >= s2)
        {
            a[root_b] = a[root_a];
            s[root_a] = s1 + s2;
            s[root_b] = 0;
        }
        else
        {
            a[root_a] = a[root_b];
            s[root_b] = s1 + s2;
            s[root_a] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int g = in.nextInt();
        int originCities_cnt = in.nextInt();
        int[] originCities = new int[originCities_cnt];
        for(int originCities_i = 0; originCities_i < originCities_cnt; originCities_i++){
            originCities[originCities_i] = in.nextInt();
        }
        int destinationCities_cnt = in.nextInt();
        int[] destinationCities = new int[destinationCities_cnt];
        for(int destinationCities_i = 0; destinationCities_i < destinationCities_cnt; destinationCities_i++){
            destinationCities[destinationCities_i] = in.nextInt();
        }
        int[] res = connectedCities(n, g, originCities, destinationCities);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + (i != res.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}