package amazon;
import java.util.*;
public class AddSubtractWithoutPlusMinus {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(add(a, b));
		System.out.println(subtract(a,b));
	}
	public static int add(int x ,int y)
	{
		while(y != 0)
		{
			int carry = x & y; // When both are set bits
			x = x ^ y;   // Normal Sum When Bits are Different
			y = carry << 1 ; // 	Right Shift
		}
		return x;
	}
	public static int subtract(int x, int y)
	{
		while(y != 0)
		{
			int borrow = ~(x) & y;
			x = x ^ y;
			y = borrow << 1;
		}
		return x;
	}

}
