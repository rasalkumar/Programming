/*
Mr. Choi has to do a marathon of D distance. He can run at 5 different paces, 
each pace will have its time consumed per km and its energy consumption.
Mr. Choi can only run till he had energy left.
Find the minimum time required for choi to complete marathon if he has H energy.


INPUT :
Input order :
Total test cases
Total Energy(10) Total Dist(5)
Next 5 lines - input for 5 different paces in min,sec and energy order

eg.
Total_energy Total_distance
Min(pace1) sec(pace1) engery_consumption(pace1)
Min(pace2) sec(pace2) engery_consumption(pace2)
Min(pace3) sec(pace3) engery_consumption(pace3)
Min(pace4) sec(pace4) engery_consumption(pace4)
Min(pace5) sec(pace5) engery_consumption(pace5)

********************


2
10 5
6 19 6
6 29 5
6 39 4
6 49 3
6 59 2
600 40
3 11 20
3 18 16
3 36 14
3 41 13
3 53 12    =>answer : 137min 11sec for 2nd TC

*/
package marathon;
import java.util.Scanner;
public class Marathon{
	/*
	Samsung Delhi IITD 2018
	Initially you have H amount of energy and D distance to travel. You may travel
	with any of the given 5 speeds. But you may only travel in units of 1 km. For 
	each km distance traveled, you will spend corresponding amount of energy.
	e.g. the given speeds are:
	Cost of traveling 1 km: [4, 5, 2, 3, 6]
	Time taken to travel 1 km: [200, 210, 230, 235, 215]
	Find minimum time required to cover total D km with remaining H >= 0
	1 <= H <= 4000
	1 <= D <= 1000
	*/

	static int INF = 100000;
	static int[] cost;
	static int[] time;

	static int dp[][][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int H = in.nextInt();
			int D = in.nextInt();
			cost = new int[n];
			for( int i = 0 ; i < n ; i++ )
			{
				cost[i] = in.nextInt();
			}
			time = new int [n];
			for( int i = 0 ; i < n ; i++ )
			{
				time[i] = in.nextInt();
			}
			
			System.out.println(getMinTime(H,D));
		}
	}
		static int getMinTime(int H, int D) {
		    dp = new int[4040][1010][5];
		    for( int i = 0 ; i < 4040 ; i++ )
			{
		    	for( int j = 0 ; j < 1010 ; j++ )
				{
		    		for( int k = 0 ; k < 5 ; k++ )
					{
		    			dp[i][j][k] = -1 ;
					}
				}
			}
		    return fun(H, D, 4);
		}

	
	static int fun(int i, int j, int k) {
	    if (i < 0) return INF;
	    if (j == 0) return 0;
	    if (k < 0) return INF;
	    if (dp[i][j][k] != -1) return dp[i][j][k];
	    return dp[i][j][k] = Math.min(fun(i, j, k - 1), time[k] + fun(i - cost[k], j - 1, k));
	}

}	
	
		
	    
	    //vector<int> cost {4, 5, 2, 3, 6};
	    //vector<int> time {200, 210, 230, 235, 215};
	    //cout << getMinTime(cost, time, t, 4);
	    //return 0;
	

	/* Verify for the following t values..
	 * 
	 * t = 16, 17, … -> 800
	 * t = 14, 15 -> 830
	 * t = 13 -> 860
	 */





















//import java.util.*;
//
//public class Marathon {
//	static Power[] power;
//	static ArrayList<ArrayList<Integer>> result;
//	static int min = Integer.MAX_VALUE;
//	static int dp[][];
//	public static void main(String args[]) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		while (t-- > 0) {
//			int h = in.nextInt();
//			int d = in.nextInt();
//			power = new Power[5];
//			for (int i = 0; i < 5; i++)
//				power[i] = new Power();
//			for (int i = 0; i < 5; i++) {
//				int x = in.nextInt();
//				int y = in.nextInt();
//				power[i].time = (x * 60) + y;
//				power[i].energy = in.nextInt();
//			}
//			dp = new int[d + 1][h + 1];
//			for (int i = 0; i <= d; i++) {
//				for (int j = 0; j <= h; j++) {
//					dp[i][j] = -1;
//				}
//			}
//			result = new ArrayList<>();
//			int ans = solve( d, h);
////			for (int i = 0; i <= d; i++) {
////				for (int j = 0; j <= h; j++) {
////					System.out.print(dp[i][j]+" ");;
////				}
////				System.out.println();
////			}
//			System.out.println((ans / 60) + "   " + (ans % 60));
//		}
//	}
//
//	public static int solve(int d, int h) {
//		if (d >= 0 && h <= 0)
//			return 0;
//		if (d == 0 && h > 0)
//			return 0;
//		if ( dp[d][h] >= 0 )
//			return dp[d][h];
//		else {
//			int min = Integer.MAX_VALUE;
//			for (int i = 0; i < 5; i++) {
//				if (power[i].energy >= h)
//					min = Math.min( min , solve( d - 1, h - power[i].energy) + power[i].time);
//				else
//					return Integer.MAX_VALUE;
//			}
//			
//			dp[d][h] = min ;
//		}
//		
//		return dp[d][h];
//	}
//
//	static class Power {
//		int time;
//		int energy;
//	}
//}
