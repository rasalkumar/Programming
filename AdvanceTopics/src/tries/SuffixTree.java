package tries;
import java.util.*;
public class SuffixTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			String s = in.next();
			Trie x = new Trie();
			int m = 0 ;
			for(int i = 0 ; i < s.length() ; i++ )
			{
				String r = s.substring(i);
				//System.out.println(r);
				x.insert(r,m);
			}
			String p = in.next();
			x.prefix(s.length(),p);
		}
	}
	static class Trie
	{
		static TrieNode root;
		static String abc = "abcdefghijklmnopqrstuvwxyz";
		
		public Trie()
		{
			root = new TrieNode(); 
		}
		public void insert(String key,int ind)
		{
			int len = key.length();
			TrieNode start = root;
			for(int i = 0 ; i < len ; i++)
			{
				int index = key.charAt(i)- 'a';
				if(start.child[index]==null)
				{
					start.child[index] = new TrieNode();
					if(start.child[index].mini>ind)
						start.child[index].mini = ind;
					
				}
				start = start.child[index];
			}
			start.endOfWord = true;
			if(start.start == -1)
			{
				start.start = ind;
			}
		}
		public void prefix(int R,String p)
		{
			String res ="";
			TrieNode pCrawl = root;
			int i = 0;
			int flag = 0;
			while(i < p.length() && pCrawl.child[p.charAt(i)-'a']!=null)
			{
				if(pCrawl.child[p.charAt(i)-'a'].mini < R)
				{
					res += p.charAt(i);
					if(res.equals(p))
					{
						flag = 1 ;
						break;
					}
					pCrawl = pCrawl.child[p.charAt(i)-'a'];
				}
				else
					break;
				i++;
			}
			System.out.println(flag);
		}
	}
	static class TrieNode
	{
		boolean endOfWord;
		int start;
		int mini;
		TrieNode[] child = new TrieNode[26];
		public TrieNode()
		{
			endOfWord = false;
			start = -1;
			mini = 100010;
			for(int i = 0 ; i < 26 ; i++ )
				child[i] = null;
		}
	}

}
