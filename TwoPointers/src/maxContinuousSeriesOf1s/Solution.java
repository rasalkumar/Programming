package maxContinuousSeriesOf1s;

import java.util.ArrayList;

import java.util.Arrays;

/**
 * http://www.careercup.com/question?id=5106425965576192
 * You are given with an array of 1s and 0s. And you are given with an integer m, which signifies number of flips allowed.
 * <p>
 * find the position of zeros which when flipped will produce maximum continuous series of 1s.
 * <p>
 * e.g.
 * input:
 * arr={1 1 0 1 1 0 0 1 1 1 } m=1
 * output={1 1 1 1 1 0 0 1 1 1} position=2
 * <p>
 * arr={1 1 0 1 1 0 0 1 1 1 } m=2
 * output={1 1 0 1 1 1 1 1 1 1} position=5,6
 *
 * @author alisovenko 26.10.14
 */
public class Solution {
	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
	    
	    ArrayList<Integer> zeroPos = new ArrayList<>();
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    if (A == null)
	        return res;
	    
	    int n = A.size();
	    
	    for (int i = 0; i < n ; i++) {
	        int num = A.get(i);
	        if (num == 0)
	            zeroPos.add(i);
	    }
	    
	    if (B >= zeroPos.size()) {
	        for (int i = 0; i < n; i++)
	            res.add(i);
	        return res;
	    }
	    
	    int i = 0;
	    int j = B;
	    int maxSize = 0;
	    int start, end;
	    start = 0;
	    
	    while (j <= zeroPos.size()) {
	        
	        if (j == zeroPos.size())
    	        end = n - 1;
    	    else
    	        end = zeroPos.get(j) - 1;
	        
	        int size = end - start + 1;
	        
	        if (size > maxSize) {
	            maxSize = size;
	            res.clear();
	            res.add(start);
	            res.add(end);
	        }
	        
	        if (j == zeroPos.size())
	            break;
	        
	        start = zeroPos.get(i) + 1;
	        i++;
	        j++;
	    }
	    
	    
	    start = res.get(0);
	    end = res.get(1);
	    
	    res.clear();
	    
	    for (i = start; i <= end; i++)
	        res.add(i);
	    
	    return res;
	    
	}


    public static void main(String[] args) {
    	ArrayList<Integer> p=new ArrayList<Integer>();
    	ArrayList<Integer> q=new ArrayList<Integer>();
    	q.add(1);
    	q.add(1);
    	q.add(0);
    	q.add(1);
    	q.add(1);
    	q.add(0);
    	q.add(0);
    	q.add(1);
    	q.add(1);
    	q.add(1);
    	Solution obj=new Solution();
        p=obj.maxone(q, 1);
        for(int i=0;i<p.size();i++)
        {
        	System.out.println(p.get(i));
        }
       // flip(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1}, 2);
    }
}