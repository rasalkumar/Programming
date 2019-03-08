/*
 * Please find the minimum cost to travel from Source to Destination location with multiple toll gates across
There are challenges at each toll gate to minimize the cost.
One can either choose to pay the toll  or 
One can battle at the toll gate to avoid paying by having his own set of men's they travel with them (initially zero) or 
One can pay double the toll cost and hire all the men at the each tolls for the next  toll to battle and avoid toll cost, 
If you choose to battle at particular toll only if you can have  no.of.. hired men is more than the count hired men at respective toll gate.    
Note:  Each hired men can battle for 3 times only
For each battle you will lose equal no.of.men with you as well as available in the toll gate .  Rest of them will lose 1 round of battle irrespective of they are alive or not.  After 3 battle they will not survive.  If you have 10 men with you and toll no. of. Toll men is 8, then you lose 8 men in battle and remaining 2 men lost  1 round of battle and hence they can be available for 2 more rounds only.
Ex: 
7             //toll no.of.tolls
10 100 //toll hire men and toll cost
70 5
80 15
20 60
50 90
30 80
10 10            
Min cost: 150


 */
package tollGate;
import java.util.*;
public class TollGate {
	static int N;
	static int t[];
	static int cc[];
	static int min_cost = 100000007;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		t = new int[N];
		cc = new int[N];
		for (int i = 0; i < N; i++) {
			t[i] = in.nextInt();
			cc[i] = in.nextInt();
		}
		dfs(0, 0, 0, 0, 0);
		System.out.println(min_cost);

	}

	public static void dfs(int p, int a, int b, int c, int cost) {
		int asum = a + b + c;
		if (cost > min_cost)
			return;
		if (p == N - 1) {
			if (asum < t[p])
				cost += cc[p];
			if (cost < min_cost)
				min_cost = cost;
			return;
		}
		dfs(p + 1, a, b, c, cost + cc[p]);
		dfs(p + 1, a + t[p], b, c, cost + 2 * cc[p]) ;
		if (asum >= t[p]) {
			if (t[p] > b + c)
				a = asum - t[p];
			if (t[p] > c)
				b = t[p] - c >= b ? 0 : b - t[p] + c ;
			dfs(p + 1, 0, a, b, cost);
		}
	}
}
