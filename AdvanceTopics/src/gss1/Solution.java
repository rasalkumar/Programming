package gss1;
import java.io.*;
public class Solution
{
	static class Tree 
	{
		int maxv, sum, lval, rval; 
		Tree(){}
	}
	static int MAX = 1 << 16;
	static int a[] ;
	static Tree[] T ;

	public static void main(String args[])throws IOException
	{
		Reader in = new Reader();
		PrintWriter out = new PrintWriter(System.out , true);
		int  m;
		a = new int[MAX];
		T = new Tree[MAX << 1];
		for(int i = 0 ; i < T.length ;i++)
			T[i] = new Tree();
		Tree res = new Tree();
		int n = in.nextInt();
		for(int i = 1 ; i <= n; i++)
		{ 
			int g = in.nextInt();
			a[i] = g;
		}
		init(1, 1, n);
		m = in.nextInt();
		while(m-- > 0)
		{
			int l = in.nextInt();
			int r = in.nextInt(); 
			find(res, 1, 1, n, l, r);
			out.println(res.maxv);
		}
	}
	static int max2(int a, int b)
	{
		return ((a > b)? a : b);
	}

	static int max3(int a, int b, int c)
	{
		return max2(a, max2(b, c));
	}

	static void init(int i, int start, int end)
	{
		if(start==end)
		{
			//T[Node] = new Tree();
			T[i].maxv = T[i].sum = T[i].rval = T[i].lval = a[start];
			return;
		}
		int mid = (start+end)/2;
		init( 2 * i , start , mid );
		init( 2 * i + 1 , mid + 1 , end);
		T[i].sum = T[ i * 2 ].sum + T[ i * 2 + 1 ].sum;
		T[i].maxv = max3(T[ 2 * i].maxv, T[ 2 * i].rval + T[ 2 * i+1].lval, T[2*i+1].maxv);
		T[i].lval = max2(T[ 2 * i].lval, T[ 2 * i].sum + T[ 2 * i + 1].lval);
		T[i].rval = max2(T[2*i].rval + T[2*i+1].sum, T[2*i+1].rval);
	}

	static void find(Tree res, int Node, int start, int end, int l, int r) {
		if(start==l && end==r) {
			res.maxv = T[Node].maxv;
			res.sum = T[Node].sum;
			res.lval = T[Node].lval;
			res.rval = T[Node].rval;
			return;
		}
		int m = (start + end)/2;
		if(r <= m) 
			find(res, 2*Node, start, m, l, r);
		else if( l > m)
			find(res, 2*Node+1, m+1, end, l, r);
		else
		{
			//Tree Left, Right ;
			find(T[2* Node], 2 * Node , start, m, l, m);
			find(T[2*Node +1], 2 * Node + 1, m+1, end, m+1, r);
			res.maxv = max3(T[2*Node].maxv, T[2*Node +1].maxv, T[2*Node].rval + T[2*Node +1].lval);
			res.sum = T[2*Node].sum + T[2*Node +1].sum;
			res.lval = max2(T[2*Node].lval, T[2*Node].sum + T[2*Node +1].lval);
			res.rval = max2(T[2*Node].rval + T[2*Node +1].sum, T[2*Node +1].rval);
		}
	}
	static class Reader {
	    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
	    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
	    }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
	    }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
	    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
	    }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
	    }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
	    }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
	    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
	    }public void close() throws IOException{if(din==null) return;din.close();}
	}

}