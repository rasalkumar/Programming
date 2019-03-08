package modularExpression;

public class Solution {
	public int Mod(int A, int B, int C) {
	    long res = 1;
	    long y = A;
	    
	    while (B > 0) {
	        
	        if (B % 2 == 1) {
	            res = res * y;
	            res %= C;
	        }
	        
	        y = y * y;
	        y %= C;
	        
	        B /= 2;
	        
	    }
	    
	    res %= C;
	    res = (res + C) % C;
	    
	    return (int) res;
	}
	public static void main(String args[])
	{
		int x=71045970;
		int n=41535484;
		int M=64735492;		
		Solution obj = new Solution();
		int mod=obj.Mod(x, n, M);
		System.out.println(mod);
	}
}

