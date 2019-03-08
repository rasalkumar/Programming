package sorting;

public class BubbleSort {
	
	public static void main(String[] args) {
		int a[] = { 8 , 2 , 4 , 1 , 3 , 6 };
		int n = a.length;
		for(int i = 0 ; i < n ; i++ )
		{
			for(int j = 1; j < n ; j++)
			{
				if(a[j]<=a[j-1])
				{
					int temp =a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		for(int i = 0 ; i < n ; i++ )
		{
			System.out.println(a[i] + " ");
		}
	}
}
