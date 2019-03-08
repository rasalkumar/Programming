package sorting;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 8 , 2 , 4 , 1 , 3 , 6 };
		int n = a.length;
		mergeSort(a);
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	// TOP DOWN MERGESORT APPROACH RASAL KUMAR
	// KEEP IT SIMPLE SILLY
	
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
				a[k++] = right[j++];
		}
		while( i < nL )
			a[k++] = left[i++];
		while( j < nR )
			a[k++] = right[j++];
	}

}
