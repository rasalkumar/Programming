package grayCode;
import java.util.*;
public class Solution {
	
	public ArrayList<Integer> grayCode(int n) {
		  if(n==0){
		        ArrayList<Integer> result = new ArrayList<Integer>();
		        result.add(0);
		        return result;
		    }
		 
		    ArrayList<Integer> result = grayCode(n-1);
		    int numToAdd = 1<<(n-1);
		 
		    for(int i=result.size()-1; i>=0; i--){   //key step
		        result.add(numToAdd+result.get(i));
		    }
		 
		    return result;
		
	}
	public static void main(String args[])
	{
		Solution obj=new Solution();
		int a=4;
		ArrayList<Integer> result=new ArrayList<Integer>();
		result=obj.grayCode(a);
		for(int i :result)
		{
			System.out.println(i);
		}
	}

}
