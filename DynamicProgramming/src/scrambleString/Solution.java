package scrambleString;

import java.util.Arrays;

public class Solution {
	public int isScramble(String s1, String s2) {
	    if(s1.length()!=s2.length())
	        return 0;
	 
	    if(s1.length()==0 || s1.equals(s2))
	        return 1;
	 
	    char[] arr1 = s1.toCharArray();
	    char[] arr2 = s2.toCharArray();
	    Arrays.sort(arr1);
	    Arrays.sort(arr2);
	    if(!new String(arr1).equals(new String(arr2))){
	        return 0;
	    }
	 
	    for(int i=1; i<s1.length(); i++){
	        String s11 = s1.substring(0, i);
	        String s12 = s1.substring(i, s1.length());
	        String s21 = s2.substring(0, i);
	        String s22 = s2.substring(i, s2.length());
	        String s23 = s2.substring(0, s2.length()-i);
	        String s24 = s2.substring(s2.length()-i, s2.length());
	 
	        if(isScramble(s11, s21)==1 && isScramble(s12, s22)==1)
	            return 1;
	        if(isScramble(s11, s24)==1 && isScramble(s12, s23)==1)
	            return 1;    
	    }    
	 
	    return 0;
	}
	public static void main(String args[])
{
	String s1="abbbcbaaccacaacc";
	String s2="acaaaccabcabcbcb";
	Solution obj=new Solution();
	System.out.println(obj.isScramble(s1, s2));
	}
}
