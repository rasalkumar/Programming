package buyMaximumStocks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int buyMaximumProducts(int n, int k, int[] a) {
        // Complete this function
    	class poto
    	{
    		int value;
    		int index;
//    		poto(int value,int index)
//    		{
//    			this.value=value;
//    			this.index=index;
//    		}
    		
    	}
    	poto p[]=new poto[n];
    	for(int i=0;i<n;i++)
    	{
    		p[i].value=a[i];
    		p[i].index=i;
    	}
    	
//    	Arrays.sort(p,new Comparator<poto>() {
//		});
//    	
    	return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int k = in.nextInt();
        int result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}