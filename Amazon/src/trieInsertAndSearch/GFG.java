package trieInsertAndSearch;

import java.util.*;

public  class GFG {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			
			Trie x = new Trie();
			for(int i = 0 ; i < n ;i++)
			{
				String s = in.next();
				x.insert(s, i);
			}
			String a = in.next();
			  x.lowPrefix(n, a);
		//	System.out.println(ans);
//			if (ans == null || a.compareToIgnoreCase(ans)!=0)
//			{
//				System.out.println(0);
//			}
//			else
//			{
//				System.out.println(1);
//			}
//			//System.out.println(s);
			
		}
		
	}
	static class TrieNode
	{
		boolean endOfWord;
		int start  ;
		int mini ;
		TrieNode child[] = new TrieNode[26];
		public TrieNode()
		{
			start = -1 ;
			mini = 100010;
			for(int i = 0 ; i < 26 ; i++ )
			{
				child[i] = null;
			}
		}
	}
	static class Trie
	{
		TrieNode root ;
		String abc = "abcdefghijklmnopqrstuvwxyz";
		 
		public Trie()
		{
			root = new TrieNode();
		}
		public void insert(String key , int ind)
		{
			int len = key.length();
			TrieNode start = root;
			for( int i  = 0 ; i < len ; i++ )
			{
				int index = key.charAt(i) - 'a' ;
				if(start.child[index] == null )
				{
					start.child[index] = new TrieNode();
					if(start.child[index].mini>ind)
					{
						start.child[index].mini = ind ;
					}  
				}
				start = start.child[index];
			}
			start.endOfWord = true;
			if(start.start == -1)
			{
				start.start = ind; 
			}
		}
		public void lowPrefix(int R , String p)
		{
			String res = "";
			TrieNode pCrawl = root;
			int  i = 0 ;
			int flag = 0;
			while( i < p.length() && pCrawl.child[p.charAt(i) - 'a' ] != null)
			{
			   if( pCrawl.child[p.charAt(i)-'a'].mini < R )
			   {
				   
				   res+=p.charAt(i); 
				   if(res.equals(p) && pCrawl.child[p.charAt(i)-'a'].endOfWord)
				   {
					  // System.out.println(1);
					   flag = 1 ;
					   break;
				   }
				   pCrawl = pCrawl.child[p.charAt(i)-'a'];
			   }
			   else
			   {
				   break;
			   }
			   i++;
			   
				
			}
			
			//System.out.println(res);
			
			System.out.println(flag);
		
		//	return res;
		}
	}
}
