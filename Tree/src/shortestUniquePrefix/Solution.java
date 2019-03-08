package shortestUniquePrefix;

import java.util.*;

public class Solution {
	public ArrayList<String> prefix(ArrayList<String> strings) {
		TrieNode root = new TrieNode();
		for(String s : strings) {
			root.insert(s, 0);
		}
		ArrayList<String> prefixes = new ArrayList<String>();
		for(String s : strings) {
			String shortestUniquePrefix = root.search(s, 0);
			prefixes.add(shortestUniquePrefix);
		}
		return prefixes;
	}
	private static final class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		private int count = 0;
		
		public void insert(String s, int i) {
			count++;
			if(i < s.length()) {
				Character current = s.charAt(i);
				if(!children.containsKey(current)) {
					children.put(current, new TrieNode());
				}
				TrieNode child = children.get(current);
				child.insert(s, i + 1);
			}
		}
		
		public String search(String s, int i) {
			String prefix = null;
			if(i > 0 && count == 1) {
				prefix = s.substring(0, i);
			} else {
				Character ch = s.charAt(i);
				TrieNode child = children.get(ch);
				prefix = child.search(s, i + 1);
			}
			return prefix;
		}
	}
	 public static void main(String[] args){
	        ArrayList<String> a = new ArrayList<String>();
	        a.add("zebra");
	        a.add("dog");
	        a.add("duck");
	        a.add("dot");
	        Solution obj=new Solution();
	        ArrayList<String> result =obj.prefix(a);
	        for(int i=0;i<result.size();i++)
	        {
	        	System.out.print(" "+result.get(i));
	        }
	        
	    }
}
