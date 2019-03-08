package rodCutting;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();

	}

	
	     private int resT[][];
	    private long arr[][] ;
	    private ArrayList<Integer> ans = new ArrayList<>();
	    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
	        int s = B.size();
	        arr = new long[s+2][];
	        resT = new int[s+2][];

	        for (int i = 0; i <=s+1 ; i++) {
	            arr[i] = new long[s+2];
	            resT[i]  =  new int[s+2];
	            Arrays.fill(arr[i],-1);
	        }
	        int tempB[] = new int[s+2];
	        tempB[0] = 0; tempB[s+1] = A;
	        for (int i = 0; i <s ; i++) {
	            tempB[i+1] = B.get(i);
	        }
	        long x = rodCutUtil(0,s+1, tempB);
	        pushBack(0,s+1,tempB);
	        return ans;
	    }

	    public long rodCutUtil(int i,int j, int []B) {
	        long ans = Long.MAX_VALUE;
	        if((j-i) ==1) return 0;
	        if(i>=j) return 0;
	        if(arr[i][j] != -1) return arr[i][j];
	        int bestI = i+1;
	        for (int k = i+1; k <= j-1; k++) {
	            long t = B[j]- B[i] + rodCutUtil(i,k,B)+rodCutUtil(k,j,B);
	            if(t<ans) {
	                ans = t;
	                bestI=k;
	            }
	        }
	        resT[i][j] = bestI;
	        arr[i][j] = ans;
	        return ans;
	    }
	    private void pushBack(int i, int j,int []B) {
	        if((j-i) ==1) return ;
	        if(i>=j) return ;
	        ans.add(B[resT[i][j]]);
	        pushBack(i,resT[i][j],B);
	        pushBack(resT[i][j],j,B);
	    }
	}


