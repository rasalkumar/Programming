package countingInversions;
import java.util.*;
public class GFG {
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			count = 0 ;
			int n = in.nextInt();
			int a[] =new int[n];
			for(int i = 0 ; i < n ; i++ )
			{
				a[i] = in.nextInt();
			}
			mergeSort(a);
			//for(int i = 0 ; i < n ;i++ )
			//	System.out.print(a[i]+ " ");
			//System.out.println();
			System.out.println(count);
		}
	}
	public static int[] mergeSort(int[] a)
	{
		int n = a.length;
		if(  n < 2 )
			return a;
		int mid = n / 2;
		int left[] = new int[mid];
		int right[] = new int[n-mid];
		
		for(int i = 0 ; i < mid ; i++ )
			left[i] = a[i];
		for(int i = mid ; i < n  ; i++ )
			right[i-mid] = a[i]; 
		
		mergeSort(left);
		mergeSort(right);
		merge(a,left,right);
		return null;
	}
	
	public static void merge(int[] a,int[] left, int[] right)
	{
		int nL = left.length;
		int nR = right.length;
		int i = 0 , j = 0, k = 0 ;
		while(i < nL && j < nR )
		{
			if(left[i]<=right[j])
				a[k++] = left[i++];
			else
			{
				a[k++] = right[j++];
				count += nL - i ;
			}
		}
		while( i < nL )
			a[k++] = left[i++];
		while( j < nR )
			a[k++] = right[j++];
	}
}