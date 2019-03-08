package signalAmplifier;
import java.util.Scanner;
public class SignalAmplifier {
	static int input[][];
	static int hash[][];
	static int candidateRowCount;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcase = in.nextInt();
	    for (int t=0; t<testcase; t++)
	    {
	    	candidateRowCount= 0;
	        int N,M,K;
	        N = in.nextInt();
	        M = in.nextInt();
	        K = in.nextInt();
	        input = new int[N][M];
	        for (int i=0; i<N; i++)
	        {
	            for (int j=0; j<M; j++)
	            {
	                input[i][j] = in.nextInt();
	            }
	        }
	        int val= getMaxCount( N, M, K);
	        //System.out.println();
	        System.out.println("Max Val  = " + val);
	    }
	}
	

	public static int getMaxCount(int N , int M, int K)
	{
	    hash = new int[N][M + 1];
	    // an extra column to save frequency of row i
//	    for(int i=0; i<M+1; i++)
//	    {
//	        hash[i]= new int[M+1];
//	        hash[i][M] =0;
//	    }
	    for( int i = 0 ; i < N ; i++ )
	        for( int j = 0 ; j <= M ; j++ )
	            hash[i][j]=0;

	    for(int i = 0 ; i < N ; i++ )
	    {
	        int count = 0;
	        for (int j=0; j<M; j++)
	        {
	            if(input[i][j]==0)
	                count++;
	        }
	        if(count<=K)
	        {
	            int diff= K-count;
	            if ((diff >= 0) && ((diff % 2) == 0))
	            {
	                populateHash(input[i], M);
	            }
	        }
	    }

	    int maxVal = 0;
	    for (int i=0; i<candidateRowCount; i++)
	    {
	        if(hash[i][M]>maxVal)
	            maxVal = hash[i][M];
	    }
	    return maxVal;
	}
	static void populateHash(int[] input,int col)
	{
	    boolean found = false;
	    for (int i=0; i<candidateRowCount; i++)
	    {
	        for (int j=0; j<col; j++)
	        {
	            if(input[j] !=hash[i][j])
	                break;
	            else
	            {
	                if (j==(col-1))
	                {
	                    found = true;
	                    hash[i][col] +=1;
	                }
	            }
	        }
	    }
	    if (!found)
	    {   // save current candidate Row  in hash to be used for comparison in else block of above steps of this function 
	        for (int i=0; i<col; i++)
	        {
	            hash[candidateRowCount][i] = input[i];
	        }
	        hash[candidateRowCount][col] +=1;
	        candidateRowCount++;
	    }
	}
}
	
