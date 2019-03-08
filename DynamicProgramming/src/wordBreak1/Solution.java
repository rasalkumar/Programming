package wordBreak1;

import java.util.*;
public class Solution {
	public int wordBreak(String s, ArrayList<String> dictionary) {
		 boolean[] t = new boolean[s.length() + 1];
	        t[0] = true;
	        
	        for(int i = 0; i < s.length(); i++){
	            if(!t[i])
	                continue;
	            for(String word : dictionary){
	                int length = word.length();
	                int end = i + length;
	                if(end > s.length())
	                    continue;
	                if(t[end])
	                    continue;
	                if(s.substring(i, end).equals(word))
	                    t[end] = true;
	            }
	        }
	        return t[s.length()]?1:0;
		
	}
	public static void main(String args[])
	{
		ArrayList<String> strings=new ArrayList<String>();
		strings.add("trainer");
		strings.add("my");
		strings.add("interview");
		String s="myinterviewtrainer";
		Solution obj=new Solution();
		System.out.println(obj.wordBreak(s, strings));
	}

}
