package sorting;

public class SelectionSort {
	public static void main(String args[])
	{
		int a[] = { 8 , 2 , 4 , 1 , 3 , 6 };
		int n = a.length;
		for(int i = 0 ; i < n ; i++)
		{
			int x = i;
			for(int j = i + 1 ; j < n; j++)
			{
				if(a[j] <= a[x])
					x = j;
			}
			int temp = a[x];
			a[x] = a[i];
			a[i] = temp;
		}
		for(int i = 0 ; i < n; i++)
		{
			System.out.println(a[i]);
		}
	}
}
