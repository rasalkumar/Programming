package doesRobotMoveCircular;

import java.util.*;

public class GFG {
	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			// Assume current direction as east and initial coordinates as (0,0) 
			int x = 0 , y = 0;
			int dir = 0;
			String s = in.next();
			for(int i = 0 ; i < s.length() ;i++)
			{
				if(s.charAt(i)=='R')
				{
					dir = (dir + 1) % 4;
				}
				else if(s.charAt(i)=='L')
				{
					dir = (4 + dir - 1) % 4;
				}
				else
				{
					if(dir == 0) //North Dir
					{
						y++;
					}
					else if(dir == 1) //West Dir
					{
						x--;
					}
					else if(dir == 2) //South Dir
					{
						y--;
					}
					else //East Dir
					{
						x++;
					}
				}
			}
			if(x==0 && y==0)
			{
				System.out.println("Circular");
			}
			else
			{
				System.out.println("Not Circular");
			}
		}
	}
}
