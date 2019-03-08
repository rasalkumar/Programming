package sonyaAndExhibition;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int L[] = new int[m];
        int R[] = new int[m];
        for( int i = 0 ; i < m ; i++ )
        {
        	L[i] = in.nextInt();
        	R[i] = in.nextInt();
        }
        int count = 0 ;
        for(int i = 0  ; i < n ;i++)
        {
        	System.out.print(count);
        	count = ( count + 1 ) & 1 ; 
        }
        
        
        
        
	}
	

}
