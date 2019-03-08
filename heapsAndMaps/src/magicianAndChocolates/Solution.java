package magicianAndChocolates;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {
	
	public int nchoc(int A, ArrayList<Integer> B) {
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
        for(int i = 0 ; i < B.size() ; i++){
            if(tm.containsKey(B.get(i))){
                tm.put(B.get(i),tm.get(B.get(i))+1);
            }
            else{
                tm.put(B.get(i),1);
            }
        }
        long sum = 0;
        int temp;
        int index;
        for(int i =0; i<A;i++){
            temp = tm.lastKey();
            
            index = tm.get(temp);
            //System.out.println(temp+" "+index+" "+sum);
            sum+=temp%1000000007;
            if(index == 1){
                tm.remove(temp);
            }
            else{
                tm.put(temp,index-1);
            }
           // System.out.println("half "+temp/2);
            if(tm.containsKey(temp/2)){
                tm.put(temp/2,tm.get(temp/2)+1);
            }
            else{
                tm.put(temp/2,1);
            }
        }
        //System.out.println((int)(sum%1000000007));
        return (int)(sum%1000000007);
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int K=3;
	//	int N=2;
		ArrayList<Integer> B=new ArrayList<>();
		B.add( 2);
		B.add( 5);
		B.add( 10);
		B.add( 11);
		B.add( 10);
		B.add( 3);
		Solution obj=new Solution();
		int  d=obj.nchoc(10, B);
		System.out.println(d);
				

	}

}
//10
//B : [ 2147483647, 2000000014, 2147483647 ]
