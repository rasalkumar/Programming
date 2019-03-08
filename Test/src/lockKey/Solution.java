package lockKey;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long key = in.nextLong();
		System.out.println(2 + 6 + "1");
		System.out.println(findUnlockKey(key));
	}
	public static long findUnlockKey(long lockingKey)
	{
		long a = Math.abs(lockingKey);
		String s = String.valueOf(a);
		char[] str = s.toCharArray();
		Arrays.sort(str);
		int i = 0 ;
		if(str[i] == '0')
		{
			while(str[i] == '0')
			{
				i++;
			}
			char temp = str[i];
			str[0] = temp;
			str[i] = '0';
		}
		String k = new String(str);
		long ans = Long.parseLong(k);
		if(lockingKey < 0)
		{
			ans = ans * -1;
		}
		return ans;
	}

}
