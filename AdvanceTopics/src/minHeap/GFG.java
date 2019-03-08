package minHeap;

//Initial Template for Java
import java.util.*;
import java.io.*;
class GfG {
public static void main(String[] args)
{
  Scanner sc=new Scanner(System.in);
 int t=sc.nextInt();
 while(t-->0)
 {
   int a=sc.nextInt();
   MinHeap h=new MinHeap(a);
  for(int i=0;i<a;i++)
    {
      int c=sc.nextInt();
      int  n;
      if(c==1)
          {  n=sc.nextInt();
          
             h.insertKey(n);
           }
      if(c==2)
         {  n=sc.nextInt();
            h.deleteKey(n);
	    } 
      if(c==3)
            { 
             System.out.print(h.extractMin()+" ");
             }
   
    }
     System.out.println();
 }
}
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
class MinHeap{
    
    public static int[] harr; 
    public static int capacity;
    public static int heap_size;
      
MinHeap(int a)
	{
		capacity = a;
		heap_size = 0 ;
		harr = new int[a];
	}
  
	public int extractMin()
	{
		if(heap_size <= 0 )
			return -1;
		if(heap_size == 1)
		{
			heap_size--;
			return harr[0];
		}
		int root = harr[0];
		harr[0] = harr[heap_size - 1];
		heap_size--;
		MinHeapify(0);
		return root;
	}
	public void MinHeapify(int i)
	{
	    if(i >= heap_size)
	        return;
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if( l < heap_size && harr[l] < harr[i] )
			smallest = l ;
		if( r < heap_size && harr[r] < harr[smallest] )
			smallest = r ;
		if(smallest != i )
		{
			swap(i,smallest);
			MinHeapify(smallest);
		}
	}

	public void insertKey(int k)
	{
		if(heap_size == capacity)
			return;
		
		heap_size++;
		int i = heap_size - 1;
		harr[i] = k ;                               // Insert Element at last
		while(i != 0 && harr[parent(i)] > harr[i] )  //Check Max Heap Property if Violated
		{
			swap(i,parent(i));
			i = parent(i);
		}
	}
	public void decreaseKey(int i , int new_val)
	{
	    if( i >= heap_size )
	        return;
		harr[i] = new_val;
		while( i != 0 && harr[parent(i)] > harr[i] )
		{
			swap(i,parent(i));
			i = parent(i);
		}
	}
	public void deleteKey(int i)
	{
	    if(i>= heap_size)
	        return;
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	public void swap(int a ,int b)
	{
		int temp = harr[a];
		harr[a] = harr[b];
		harr[b] = temp;
	}
	public int parent(int i)
	{
		return (i-1)/2;
	}
	public int left(int i)
	{
		return (2 * i) + 1 ;
	}
	public int right(int i)
	{
		return (2 * i) + 2 ;
	}
}