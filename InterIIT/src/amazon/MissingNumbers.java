package amazon;
import java.util.*;
public class MissingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n =  in.nextInt();
		int a[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = in.nextInt();
		}
		int shift = segregate(a, a.length);
		int arr2[] = new int[a.length - shift];
		int j =  0 ; 
		for(int i = shift ; i < a.length ; i++ )
		{
			arr2[j] = a[i];
			j++;
		}
		System.out.println(missingPositive(arr2, arr2.length));
		

	}
	static int segregate(int[] arr, int size)
	{
		int j = 0 ;
		for(int i = 0 ; i < size ; i++ )
		{
			if( arr[i] <= 0 )
			{
				int temp;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return j;
	}
	static int missingPositive(int[] a ,int size)
	{
		for(int i = 0 ; i < size ; i++)
		{
			int x = Math.abs(a[i]);
			if(x - 1 < size && a[x - 1] > 0)
			{
				a[x -1] = -a[x -1];
			}
		}
		for(int i = 0 ; i < size ; i++ )
		{
			if( a[i] > 0 )
				return i + 1;
		}
		return size + 1;
		
		
		
	}

}
