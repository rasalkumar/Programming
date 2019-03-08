package dpSet8;

class MatrixChainMultiplication {
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	static int MatrixChainOrder(int p[], int i, int j, int[][] cache, int[][] splits) {
	    if(i==j) return 0;
	    if(i>j) return 0;
	    if(cache[i][j]!=0) return cache[i][j];
	    
	    int min = Integer.MAX_VALUE;
	    int idx = -1;
	    for(int k=i; k<j; k++) {
	        int ops = MatrixChainOrder(p, i, k, cache, splits) + MatrixChainOrder(p, k+1, j, cache, splits) + p[i-1]*p[k]*p[j];
	        if(ops<min) {
	            min = ops;
	            idx = k;
	        }
	    }
	    cache[i][j] = min;
        splits[i][j] = idx;
	    return min;
	}
	
	public static String buildString(String s, int[][] splits, int i, int j) {
	    if(i==j) return String.valueOf(s.charAt(i));
	    return "(" + buildString(s, splits, i, splits[i][j]) + buildString(s, splits, splits[i][j]+1, j) + ")";
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr[] = new int[] {1, 2, 3, 4, 3};
		int n = arr.length;
        int[][] cache = new int[5][5];
        int[][] splits = new int[5][5];

		System.out.println("Minimum number of multiplications is "+
						MatrixChainOrder(arr, 1, n-1, cache, splits));
        System.out.println(buildString("*ABCD", splits, 1, 4));
	}
}