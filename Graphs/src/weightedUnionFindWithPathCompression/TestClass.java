package weightedUnionFindWithPathCompression;
import java.util.*;
public class TestClass {
	public static int a[]=new int[20005];
	public static int size[]=new int[20005];
	public static int count;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		count=N;
		for(int i=1;i<=N;i++)
		{
			a[i]=i;
			size[i]=1;
			
			
		}
		for(int i=1;i<=M;i++)
		{
			int x=in.nextInt();
			int y=in.nextInt();
			weightedUnionWithPathCompression(a,size,x,y);
			//Arrays.sort(size, i, M);
			System.out.println(count);
//			for(int j=1;j<N;j++)
//			{
//			     System.out.print(size[j]+" ");
//			}
		//	System.out.println();
		}
		
	}
	public static int findRoot(int[] a,int i)
	{
		while(a[i]!=i)
		{
			a[i]=a[a[i]];
			i=a[i];
		}
		return i;
	}
	public static void weightedUnionWithPathCompression(int[] a,int[] size,int A,int B)
	{
		int root_A=findRoot(a, A);
		int root_B=findRoot(a, B);
		if(size[root_A]<size[root_B])
		{
			a[root_A]=a[root_B];
			size[root_B]=size[root_B]+size[root_A];
		}
		else
		{
			a[root_B]=a[root_A];
			size[root_A]+=size[root_B];
		}
		count--;
		
	}
	public static boolean find(int a[],int A,int B)
	{
		if(findRoot(a, A)==findRoot(a, B))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
