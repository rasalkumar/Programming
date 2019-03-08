package interviewQuestion;

import java.util.Arrays;
import java.util.List;

public class BitonicArray {
	
	public int search(final List<Integer> A,int B)
	{
		int a[]=new int[A.size()];
		for(int i=0;i<A.size();i++)
		{
			a[i]=A.get(i);
		}
		int start,end;
		int n=A.size();
		int pivot=getMinElementIndex(A);
		start=pivot;
		end=n-1;
		int res=Arrays.binarySearch(a, start, end, B);
		if(res==-1)
		{
			start=0;
			end=pivot-1;
			res=Arrays.binarySearch(a, start, end, B);
		}
		return res;
	}

	private int getMinElementIndex(List<Integer> a) {
		// TODO Auto-generated method stub
		int first,last,start,end;
		int count, num,n;
		int mid;
		int next,prev;
		n=a.size();
		count=n;
		first=a.get(0);
		last=a.get(n-1);
		start=0;
		end=n-1;
		while(count>0)
		{
			mid = start + (end-start)/2 ;
			num = a.get(mid);
			next = a.get((mid+1)%n);
			prev = a.get((mid-1+n)%n);
			
			if((num<prev)&&(num<next))
			{
				return mid;
			}
			if((num>first)&&(num>last))
			{
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
			count /= 2;
			
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Autos-generated method stub
		List<Integer> a = Arrays.asList(4,5,6,7,0,1,2);
		int x=5;
		int t;
		BitonicArray b=new BitonicArray();
		t=b.search(a, x);
		System.out.println(t);

	}

}
