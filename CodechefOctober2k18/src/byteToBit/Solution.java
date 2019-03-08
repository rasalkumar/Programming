package byteToBit;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			long bitCount = 1, nibbleCount = 0, byteCount = 0;
			for(int i = 0 ; i < n ;i += 26)
			{
				
				int j = i ;
				while( j <= Math.min(26 + i , n))
				{
					if (j % 26 == 1)
					{
						if(byteCount != 0)
						{
							bitCount = 2 * byteCount ;
							byteCount = 0;
						}
					}
					if(j % 26 == 3)
					{
						nibbleCount = bitCount;
						bitCount = 0;
					}
					if(j % 26 == 11)
					{
						byteCount = nibbleCount;
						nibbleCount = 0;
					}
					j++;
				}
				
			}
			System.out.println(bitCount + " " + nibbleCount + " " + byteCount);
		}
	}

}
