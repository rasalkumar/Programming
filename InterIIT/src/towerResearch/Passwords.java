package towerResearch;
import java.util.*;
public class Passwords {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String arr[] = new String[n];
		for (int i=0; i<n; i++)
			arr[i] = in.next();
		// int check[26][2] = {0};
		int[][] check = new int[26][2];
		//check.resize (26, vector <int> (2, 0));
		HashMap<int[][],Integer > mp = new HashMap<>();
		for(int i = 0 ; i < n ; i++ )
		{
			for (int j = 0 ; j < arr[i].length() ; j++)
			{
				check[arr[i].charAt(j) - 'a'][j%2]++;
			}
			if(!mp.containsKey(check))
			{
				mp.put(check, 1);
			}
			else
			{
				mp.put(check, mp.get(check) + 1);
			}
		}
		// your code goes here
		System.out.println(mp.size());
		

	}

}
