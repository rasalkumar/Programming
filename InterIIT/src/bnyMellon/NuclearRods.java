package bnyMellon;
import java.util.*;
public class NuclearRods {

	public static void main(String[] args)  
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int pairsCount =in.nextInt();
		in.nextLine();
		String[] pairs = new String[pairsCount];
		String pair;
		for (int i = 0; i < pairsCount; i++)
		{
			pair = in.nextLine();
			pairs[i] = pair;
		}

		int res = calcCost(n, pairs);
		System.out.println(res);
	}

	private static int calcCost(int n, String[] pairs) {
		int[] parent, size;
		
		parent = new int[n + 1];
		size = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		for (String pair : pairs) {
			String[] xy = pair.split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			union(x, y, parent, size);
		}
		int res = 0;
		for (int z : size) {
			res += (int) Math.ceil(Math.sqrt(z));
		}
		return res;
	}

	private static int find(int x, int[] parent)
	{
		while (x != parent[x]) {
			x = parent[parent[x]];
		}
		return x;
	}

	private static void union(int x, int y, int[] parent, int[] size) {
		
		int xRoot = find(x, parent);
		int yRoot = find(y, parent);
		
		if (xRoot == yRoot)
			return;
		
		if (size[xRoot] < size[yRoot])
		{
			parent[xRoot] = yRoot;
			size[yRoot] += size[xRoot];
			size[xRoot] = 0;
		} 
		else 
		{
			parent[yRoot] = xRoot;
			size[xRoot] += size[yRoot];
			size[yRoot] = 0;
		}
	}

}
