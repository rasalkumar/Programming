package maxMin;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		System.out.println(maxMin(k,arr));
	}
static long maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long min = Long.MAX_VALUE;
        int[] b= new int[n];
        long temp = 0;
        for(int i = 0 ; i <= n - k ; i++ )
        {
        	temp = arr[i + k -1] - arr[i] ;
        	if(min > temp)
        		min = temp;
        }
        
        return min;
    }


}
