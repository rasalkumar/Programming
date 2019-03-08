package twoSumSubString;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		// code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s = in.next();
            if (s.length() % 2 !=0)
            {
            	s = "0"+s; 
            }
            if(s.length()<6)
            {
            	System.out.println(0);
            }
		//	System.out.println(s.substring(s.length() - 3, s.length() - 1));
            else{
			String ans = helper(s);
			if (ans == "?") {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
            }

	}

	public static String helper(String s) {
		if (s.length()<6) {
			return "?";
		}
		
		if (Integer.parseInt(s.substring(s.length() - 2,
				s.length())) == (Integer.parseInt(s.substring(s.length() - 4, s.length() - 2))
						+ Integer.parseInt(s.substring(s.length() - 6, s.length() - 4)))) {
			//System.out.println(s.substring( 0 , s.length() - 2 ));
			return helper(s.substring( 0 , s.length() - 2 ));
		}
		return null;
	}
}
