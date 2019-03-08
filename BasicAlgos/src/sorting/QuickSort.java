package sorting;

public class QuickSort {
	static int a[] = { 8 , 2 , 4 , 1 , 3 , 6 };
	public static void main(String[] args) {
		int start = 0 ; 
		int end = a.length-1;
		quickSort(start,end);
		for(int i = 0 ; i < a.length; i++ )
		{
			System.out.println(a[i]+ " ");
		}
	}
	public static void quickSort(int start, int end)
	{
		if(start<end)
		{
			int partitionIndex = Partition(start,end);
			quickSort(start , partitionIndex - 1 );
			quickSort( partitionIndex + 1 , end );
		}
	}
	public static int Partition(int start, int end)
	{
		int pivot = a[end];
		int partitionIndex = start;
		for(int i = start; i < end ; i++ )
		{
			if(a[i] <= pivot )
			{
				swap( partitionIndex , i );
				partitionIndex++;
			}
		}
		swap(end,partitionIndex);
		return partitionIndex;
	}
	public static void swap(int i ,int j)
	{
		int z= a[i];
		a[i] =a[j];
		a[j] =z;
	}
}
