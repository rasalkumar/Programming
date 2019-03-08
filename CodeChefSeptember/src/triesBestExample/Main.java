package triesBestExample;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rasal
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SheokandAndString solver = new SheokandAndString();
       // int testCount = Integer.parseInt(in.next());
       // for (int i = 1; i <= 1; i++)
            solver.solve( in, out);
        out.close();
    }

    static class SheokandAndString {
        public void solve( Scanner in, PrintWriter out) {
            int n = in.nextInt();
            Trie inpTrie = new Trie();
            for (int test = 0; test < n; ++test) {
                String inp = in.next().toLowerCase();
                inpTrie.insert(inp, test);
            }

            int Q = in.nextInt();

            for (int x = 0; x < Q; ++x) {
                int R = in.nextInt();
                String P = in.next().toLowerCase();
                String res = inpTrie.lowprefix(R, P);
                out.println(res);
            }

        }

        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            boolean isEndOfWord;
            int start;
            int mini;

            public TrieNode() {
                isEndOfWord = false;
                start = -1;
                mini = 100010;
                for (int i = 0; i < 26; i++) {
                    child[i] = null;
                }
            }

        }

        class Trie {
            TrieNode root;
            String abc = "abcdefghijklmnopqrstuvwxyz";

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String key, int ind) {
                int len = key.length();
                TrieNode start = root;
                for (int i = 0; i < len; ++i) {
                    int index = key.charAt(i) - 'a';
                    if (start.child[index] == null) {
                        start.child[index] = new TrieNode();
                        if (start.child[index].mini > ind) {
                            start.child[index].mini = ind;
                        }
                    }
                    start = start.child[index];
                }
                start.isEndOfWord = true;
                if (start.start == -1) {
                    start.start = ind;
                }
            }

            public String lowprefix(int R, String P) {
                TrieNode pCrawl = root;
                String res = "";
                int i = 0;
                while (i < P.length() && pCrawl.child[P.charAt(i) - 'a'] != null) {
                    if (pCrawl.child[P.charAt(i) - 'a'].mini < R) {
                        pCrawl = pCrawl.child[P.charAt(i) - 'a'];
                        res += P.charAt(i);
                    } else {
                        break;
                    }
                    ++i;
                }

                int j = 0;
                while (pCrawl != null) {

                    if (pCrawl.isEndOfWord == true && pCrawl.start < R) {
                        return res;
                    } else {
                        for (j = 0; j < 26; ++j) {
                            if (pCrawl.child[j] != null && pCrawl.child[j].mini < R) {
                                pCrawl = pCrawl.child[j];
                                res += abc.charAt(j);
                                break;
                            }

                        }

                    }
                }
                return res;
            }

        }

    }
}

