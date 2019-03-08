package sqrtdecomp;

class Test
{
    static final int MAX = 10001;
     
    // updating the bit array of a valid block
    static void update(int idx, int blk, int val, int bit[][])
    {
        for (; idx<MAX; idx += (idx&-idx))
            bit[blk][idx] += val;
    }
      
    // answering the query
    static int query(int l, int r, int k, int arr[], int blk_sz,
                                          int bit[][])
    {
        // traversing the first block in range
        int sum = 0;
        while (l<r && l%blk_sz!=0 && l!=0)
        {
            if (arr[l] <= k)
                sum++;
            l++;
        }
      
        // Traversing completely overlapped blocks in
        // range for such blocks bit array of that block
        // is queried
        while (l + blk_sz <= r)
        {
            int idx = k;
            for (; idx > 0 ; idx -= idx&-idx)
                sum += bit[l/blk_sz][idx];
            l += blk_sz;
        }
      
        // Traversing the last block
        while (l <= r)
        {
            if (arr[l] <= k)
                sum++;
            l++;
        }
        return sum;
    }
      
    // Preprocessing the array
    static void preprocess(int arr[], int blk_sz, int n, int bit[][])
    {
        for (int i=0; i<n; i++)
            update(arr[i], i/blk_sz, 1, bit);
    }
      
    static void preprocessUpdate(int i, int v, int blk_sz,
                          int arr[], int bit[][])
    {
        // updating the bit array at the original
        // and new value of array
        update(arr[i], i/blk_sz, -1, bit);
        update(v, i/blk_sz, 1, bit);
        arr[i] = v;
    }
     
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {5, 1, 2, 3, 4};
      
        // size of block size will be equal to square root of n
        int blk_sz = (int) Math.sqrt(arr.length);
      
        // initialising bit array of each block
        // as elements of array cannot exceed 10^4 so size
        // of bit array is accordingly
        int bit[][] = new int[blk_sz+1][MAX];
      
        preprocess(arr, blk_sz, arr.length, bit);
        System.out.println(query(1, 3, 1, arr, blk_sz, bit));
      
        preprocessUpdate(3, 10, blk_sz, arr, bit);
        System.out.println(query(3, 3, 4, arr, blk_sz, bit));
        preprocessUpdate(2, 1, blk_sz, arr, bit);
        preprocessUpdate(0, 2, blk_sz, arr, bit);
        System.out.println(query (0, 4, 5, arr, blk_sz, bit));
    }
}