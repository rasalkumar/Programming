package set1;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    InputStream inputStream=System.in;
	    OutputStream outputStream = System.out;
	    Scanner in = new Scanner(inputStream);
	    PrintWriter out = new PrintWriter(outputStream);
	    FibonacciNumber solver=new FibonacciNumber();
	    int t=Integer.parseInt(in.next());
	    for(int i=1;i<=t;i++)
	    {
	        solver.solve(i,in,out);
	    }
	}
	/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rasal
 */
	    static class FibonacciNumber{
	        
	    public void solve(int testNumber, Scanner in, PrintWriter out)
	    {
	    int n=in.nextInt();      
	    out.println(fib(n));
		//code
	}
	public static int MAX=1000;
	int f[]=new int[MAX];
	
	int fib(int n)
	{
	    if(n==0)
	    {
	        return 0;
	    }
	    if(n==1 || n==2)
	    {
	        return(f[n]=1);
	    }
	    if(f[n]!=0)
	    {
	        return f[n];
	    }
	    int k = ((n&1)!=0)? (n+1)/2:(n/2); 
	    f[n]= ((n&1)!=0)?((fib(k)*fib(k))+(fib(k-1)*fib(k-1))):((2*fib(k-1))+(fib(k)*fib(k)));
	    return f[n]; 
	    
	}
  }
}  
