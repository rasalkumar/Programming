package dpSet6;
//Given a N X N  matrix Matrix[N][N] of positive integers.  
//There are only three possible moves from a cell Matrix[r][c].
//1. Matrix[r+1][c]
//2. Matrix[r+1][c-1]
//3. Matrix[r+1][c+1]
//Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
//Input:
//The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows.
//The first line of each test case contains a single integer N denoting the order of matrix. Next line contains N*N integers denoting the
//elements of the matrix in row-major form.
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int z=0;z<T;z++){
		    int N = in.nextInt();
		    int arr[][] = new int[N][N];
		    for(int i=0;i<N;i++){
		        for(int j=0;j<N;j++){
		            arr[i][j] = in.nextInt();
		        }
		    }
		    
		    int dp[][] = new int[N][N];
		    
		    //Initializing first row
		    for(int i=0;i<N;i++){
		       dp[0][i] = arr[0][i];
		    }
		    
		    for(int i=1;i<N;i++){
		        for(int j=0;j<N;j++){
		            int x = dp[i-1][j];
		            if(j>0)
		                x = Math.max( x , dp[i-1][j-1] );
		            if(j<N-1)
		                x = Math.max( x , dp[i-1][j+1] );
		            dp[i][j]= dp[i][j]+arr[i][j] + x ;
		        }
		    }
		    
		    int max = dp[N-1][0];
		    for(int i=1;i<N;i++){
		        max = Math.max(max, dp[N-1][i]);
		    }
		    
		    System.out.println(max);
		}
	}
}