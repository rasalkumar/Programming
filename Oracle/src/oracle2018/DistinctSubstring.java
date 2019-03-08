package oracle2018;
import java.util.*;
public class DistinctSubstring {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			String s = in.next();
			int[] visited = new int[256];
			for(int i = 0 ; i < 256; i++ )
			{
				visited[i] = -1;
			} 
			visited[s.charAt(0)] = 0;
			int max_len = 1;
			int curr_len = 1;
			int prev_index;
			for(int i = 1 ; i < s.length() ; i++ )
			{
				prev_index = visited[s.charAt(i)];
				if(prev_index == -1 || i - curr_len > prev_index)
				{
					curr_len++;
				}
				else
				{
					if(curr_len > max_len)
						max_len = curr_len;
					curr_len = i - prev_index;
				}
				visited[s.charAt(i)] = i ;
			}
			if(curr_len>max_len)
				max_len = curr_len;
			System.out.println(max_len);
		}
		
	}

}
