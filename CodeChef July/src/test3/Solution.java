package test3;
import java.util.*;
public class Solution {
	static int n;
	static int q;
	static int count;
	static int index;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		q = in.nextInt();
		
		String[] str = new String[n];
		for(int i = 0 ; i < n ;i++)
		{
			str[i] = in.next();
			//System.out.println(str[i]);
		}
		for(int i = 0 ; i < q ; i++ )
		{
			Trie trie = new Trie();
			String x = in.next();
			for( int j = 0 ; j < x.length() ; j++ )
			{
				//System.out.println(x.substring(j));
				trie.insert(x.substring(j));
			}
			count = 0;
			index = -1;
			for(int k = 0 ; k < n ; k++ )
			{
				trie.helper(str[k], k);
				if(count == 2)
					break;
			}
			if(count == 1)
			{
				System.out.println(index);
			}
			else if(count == 0)
			{
				System.out.println("0");
			}
			else
			{
				//System.out.println(count + "**");
				System.out.println("-1");
			}
		}
		
	}
	static class Trie
	{
		TrieNode root;
		Trie()
		{
			root = new TrieNode();
		}
		public void insert(String key)
		{
			int len = key.length();
			TrieNode start = root;
			for(int i = 0 ; i < len ; i++ )
			{
				int index = key.charAt(i) - 'a';
				if(start.child[index] == null)
				{
					start.child[index] = new TrieNode();
				}
				start = start.child[index];
			}
		}
		public void helper(String p,int ind)
		{
			TrieNode pCrawl = root;
			int i = 0;
			while( i < p.length() && pCrawl.child[p.charAt(i)-'a'] != null )
			{
				//System.out.println(p.charAt(i) +" " + i);
				i++;
				if(i == p.length())
				{
					count++;
					index = ind + 1;
				}
				pCrawl = pCrawl.child[p.charAt(i-1)-'a'];
			}
		}
	}
	static class TrieNode
	{
		TrieNode child[] = new TrieNode[26];
		TrieNode()
		{
			for(int i = 0 ; i < 26 ;i++)
				child[i] = null;
		}
	}

}
