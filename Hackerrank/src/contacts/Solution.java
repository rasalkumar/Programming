package contacts;

import java.io.*;
import java.util.*;

public class Solution {

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) 
    {
        Trie trie = new Trie();
        ArrayList<Integer> a= new ArrayList<>();
        for( int i = 0 ; i < queries.length ; i++ )
        {
            if(queries[i][0].equals("add"))
                trie.insert(queries[i][1]);
            if(queries[i][0].equals("find"))
                a.add(trie.prefix(queries[i][1]));
        }
        int[] x = new int[a.size()];
        for(int i = 0 ;  i < x.length ;i++)
        {
            x[i] = a.get(i);
        }
        return x;    
    }
    static class Trie
    {
        TrieNode root ;
        String abc = "abcdefghijklmnopqrstuvwxyz";
        public Trie()
        {
            root = new TrieNode(); 
        }
        public void insert(String key)
        {
            int len = key.length();
            TrieNode start = root;
            for(int i = 0 ; i < len ; i++)
            {
                int index = key.charAt(i) - 'a';
                if( start.child[index] == null )
                {
                    start.child[index] = new TrieNode();
                }
                
                start = start.child[index];
                start.count++;
            }
        }
        public int prefix(String p)
        {
            TrieNode pCrawl = root;
            int i = 0 ;
            while( i < p.length() && pCrawl.child[p.charAt(i) - 'a'] != null )
            {
            	System.out.println(p.charAt(i));
                i++;
                if(i == p.length())
                {
                    return pCrawl.child[p.charAt(i-1) - 'a'].count; 
                }
                pCrawl = pCrawl.child[p.charAt(i-1) - 'a'];
            }
            return 0;
        }
    }
    static class TrieNode
    {
        TrieNode child[] = new TrieNode[26];
        int count;
        public TrieNode()
        {
            count = 0;
            for( int i = 0 ; i < 26 ; i++ )
                child[i] = null;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for(int i = 0 ;i < result.length ; i++ )
        {
        	System.out.println(result[i]);
        }
    }
}
