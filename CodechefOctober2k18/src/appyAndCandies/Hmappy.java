package appyAndCandies;
import java.util.*;
public class Hmappy {
		public static int mod = 1000000007;
		static long n,m;
		static long arr[] = new long[100005];
		static long brr[] = new long[100005];
		
		public static void main(String args[])
		{
		    
		    Scanner in = new Scanner(System.in);
		    n = in.nextLong();
		    m = in.nextLong();
		    long lo=0;
		    long hi=0;
		    for(int i=0;i<n;i++){
		        arr[i] = in.nextInt();
		    }
		    for(int i=0;i<n;i++){
		        brr[i] = in.nextInt();
		        hi = Math.max(hi,brr[i]*arr[i]);
		    }
		    System.out.println(binary(lo,hi));
		   
		 }
		
		
		public static long checker(long val)
		{
		    long totalbal =0;
		    for(int i=0;i<n;i++){
		    	if(arr[i]*brr[i] <= val)
		            continue;
		    	long bgiven =(long)Math.ceil(arr[i] - val/brr[i]);
		        totalbal += bgiven;
		        if( totalbal > m )
		            return 0;
		    }
		    return 1;
		}
		 
		public static long binary(long lo, long hi){
		    while(lo<hi){
		        long mid = lo + (hi - lo )/2;
		        if(checker(mid) == 1)
		            hi=mid;
		        else
		            lo=mid+1;
		    }
		    return lo;
		}
		 
		
	

}
