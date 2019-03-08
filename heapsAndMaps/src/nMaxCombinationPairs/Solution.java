package nMaxCombinationPairs;
import java.lang.reflect.Array;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int A[] = { 4, 2, 5, 1 };
        int B[] = { 8, 0, 5, 3 };
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0 ; i < A.length ; i++)
        {
        	a.add(A[i]);
        }
        for(int i = 0 ; i < B.length ; i++)
        {
        	b.add(B[i]);
        }
        
        Solution obj = new Solution();
        ArrayList<Integer> ans = obj.solve(a,b);
       
	}
	public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(a==null||b==null)
        {
            return ans;
        }
        Collections.sort(a);
        Collections.sort(b);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(a.size(), Collections.reverseOrder());
        for(int i:a){
            for(int j:b){
                int s = i+j;
                if (pq.size()<a.size()){
                    pq.add(s);
                } else {
                    if (s>pq.peek()){
                        pq.poll();
                        pq.add(s);
                    }else{
                        break;
                    }
                }
            }
        }
        ans = new ArrayList<>(pq);
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
    
}
