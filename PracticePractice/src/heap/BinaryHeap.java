package heap;

class BinaryHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int harr[];
	static int size;
	static int capacity;
	
	static int parent(int i)
	{
		return (i-1) / 2 ;
	}
	static int left(int i)
	{
		return ( 2 * i ) + 1 ;
	}
	static int right(int i)
	{
		return ( 2 * i ) + 2 ;
	}
	static void swap(int a, int b)
	{
		int temp = harr[a];
		harr[a] = harr[b];
		harr[b] = temp;
	}
	BinaryHeap(int a)
	{
		size = 0;
		capacity = a;
		harr = new int[a];
	}
	public void insert(int k)
	{
		if(size == capacity)
			return;
		 size++;
		 int i = size - 1;
		 harr[i] = k ;
		 while(i != 0 && harr[parent(i)] > harr[i] )
		 {
			 swap(i,parent(i));
			 i = parent(i);
		 }
	}
	public void deleteKey(int i)
	{
		if(i > size)
			return;
		decreaseKey(i);
		extractMin();
	}
	public void decreaseKey(int i)
	{
		harr[i] = Integer.MIN_VALUE;
		while(i != 0 && harr[parent(i)]>harr[i])
		{
			swap(i,parent(i));
			i = parent(i);
		}
	}
	public int extractMin()
	{
		int root = harr[0];
		harr[0] = harr[size - 1];
		size--;
		MinHeapify(0);
		return root;
	}
	public void MinHeapify(int i)
	{
		if(i >= size)
			return;
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if( l < size && harr[l] < harr[i] )
		{
			smallest = l ;
		}
		if( r < size && harr[r] < harr[smallest] )
		{
			smallest = r ;
		}
		
		if( smallest != i )
		{
			swap(i,smallest);
			MinHeapify(smallest);
		}
	}

}
