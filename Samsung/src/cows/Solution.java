package cows;
import java.util.Scanner;
//import java.util.Arrays;;
public class Solution {
	static long a[];
	static ArrayList<Long> ans ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long c = in.nextLong();
		a = new long[n];
		ans = new ArrayList<>();
		for(int i = 0 ; i < n ; i++ )
		{
			a[i] = in.nextLong();
		}
//		for(int i = 0 ;  i < a.length ;  i++ )
//			System.out.print(a[i]+ " ");
		mergeSort(a);
//		System.out.println();
//		for(int i = 0 ;  i < a.length ;  i++ )
//			System.out.print(a[i]+ " ");
		long l = 0;
		long r = a[n-1] - a[0];
		while(l < r -1)
		{
			long mid = l + (r-1) / 2 ;
			if(check(mid,c,n,0))
			{
				l = mid;
			}
			else
			{
				r = mid - 1;
				
			}
		}
		if(check(l+1,c,n,1)){
			System.out.println(l+1);
	        for(int i=0;i<ans.size();i++){
	            System.out.print( ans.get(i) + " ");
	        }
	        System.out.println();
	    }
	    else if(check(l,c,n,1)){
	        System.out.println(l);
	        for(int i=0;i<ans.size();i++){
	            System.out.print(ans.get(i) + " ");;
	        }
	    }
	}
	public static boolean check(long dis,long c,int n,int flag)
	{
		long pre = a[0];
		int  i ,cnt = 1;
		if(flag == 1)
		{
			ans.clear();
			ans.add(a[0]);
		}
		for(i = 1 ; i < n ; i++ )
		{
			if(a[i] - pre >= dis )
			{
				cnt++;
				pre = a[i];
				if(flag == 1 && cnt <= c)
				{
					ans.add(a[i]);
				}
			}
		}
		if(cnt >= c)
			return true;
		return false;
	}
	public static void mergeSort(long[] a)
	{
		int n = a.length;
		if(n < 2)
			return ;
		int mid = n / 2;
		long left[] = new long[mid];
		long right[] = new long[n - mid];
		for(int i = 0 ; i < mid ; i++ )
			left[i] = a[i];
		for(int i = mid ; i < n ; i++)
			right[i - mid] = a[i];
		mergeSort(left);
		mergeSort(right);
		merge(a,left,right);
		
	}
	public static void merge(long[] a ,long[] left, long[] right )
	{
		int i = 0 , j = 0, k= 0;
		int nL = left.length;
		int nR = right.length;
		while(i < nL && j < nR)
		{
			if(left[i] <= right[j])
			{
				a[k++] = left[i++];
			}
			else
			{
				a[k++] = right[j++];
			}
		}
		while(i < nL)
		{
			a[k++] = left[i++];
		}
		while(j < nR)
		{
			a[k++] = right[j++];
		}
	}
	public static class ArrayList<T>
	{
		T[] a;
		int actSize;
		ArrayList()
		{
			a = (T[]) new Object[100005];
		}
		public void add(T x)
		{
			a[actSize++] = x ;
		}
		public int size()
		{
			return actSize;
		}
		public T get(int index)
		{
			return a[index];
		}
		public void clear()
		{
			a = (T[]) new Object[100005];
			actSize = 0;
		}
		
	}

}
