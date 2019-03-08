package painterPartitionBinarySearch;
import java.util.*;
public class PainterPartition {
static int n , k;
static int board[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		board = new int[n];
		long sum = 0 ;
		long max = Long.MIN_VALUE;
		for(int i = 0  ; i < n ; i++)
		{
			board[i] = in.nextInt();
			sum = sum + board[i];
			max = Math.max(max, board[i]);
		}
		//System.out.println(max + " " + sum);
		System.out.println(binarySearch(max, sum));

	}
	public static long binarySearch(long start, long end)
	{
		long ans = start;
		while(start <= end)
		{
			long mid = start + ((end - start) / 2 );
			//System.out.println(mid);
			if(helper(mid))
			{
				//System.out.println("**");
				ans = mid;
				end = mid-1;
			}
			else
			{
				start = mid + 1;
			}
		}
		return ans;
	}
	public static boolean helper(long val)
	{
		long count = 1 ;
		long sum =  0;
		for(int i = 0  ; i < n ; i++)
		{
			if(sum + board[i] > val)
			{
				//System.out.println("**");
				sum = board[i];
				count++;
				if(count > k)
				{
					return false;
				}
			}
			else
			{
				sum += board[i];
			}
		}
		return true;
	}
}
